$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'context/list',
        datatype: "json",
        colModel: [			
			{ label: '系统编号', name: 'id', index: 'id', width: 50, key: true },
			{ label: '文章编号', name: 'bookId', index: 'book_id', width: 80 }, 			
			{ label: '文章来源', name: 'bookType', index: 'book_type', width: 80 , formatter: function(value, options, row){
				switch (value) {
				case 1:
					return '百家号';
				case 2:
					return 'UC头条';
				default:
					return 'error';
				}
			}}, 			
			//{ label: '文章内容', name: 'context', index: 'context', width: 80 }, 			
			//{ label: '作者编号', name: 'authorId', index: 'author_id', width: 80 }, 			
			//{ label: '发布时间', name: 'publishDate', index: 'publish_date', width: 80 }, 			
			{ label: '文章标题', name: 'title', index: 'title', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			booktype: 0
		},
		showList: true,
		title: null,
		contexthtml : null,
		context: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.context = {};
		},
		browse: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.context.id == null ? "context/save" : "context/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.context),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "context/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "context/info/"+id, function(r){
                vm.context = r.context;
                vm.contexthtml = r.context.context;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                postData:{'booktype': vm.q.booktype},
                page:page
            }).trigger("reloadGrid");
		}
	}
});

vm.query;