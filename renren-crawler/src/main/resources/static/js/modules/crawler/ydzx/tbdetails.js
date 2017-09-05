$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'tbdetails/list',
        datatype: "json",
        colModel: [			
			{ label: '编号', name: 'id', index: 'id', width: 50, key: true },			
			{ label: '标题', name: 'title', index: 'title', width: 80 },  			
			{ label: '简介', name: 'summary', index: 'summary', width: 80 }, 	
			{ label: '正文内容', name: 'contextHtml', index: 'context_html', width: 80 }, 			
			{ label: '发布时间', name: 'date', index: 'date', width: 80 }, 	
			{ label: '作者编号', name: 'authorId', index: 'author_id', width: 80 }, 					
			//{ label: '正文内容', name: 'contextText', index: 'context_text', width: 80 }, 			
			//{ label: '分类', name: 'ctype', index: 'ctype', width: 80 }, 		
			//{ label: '加密后url后缀', name: 'docid', index: 'docid', width: 80 }, 			
			//{ label: '暂时未知分类', name: 'dtype', index: 'dtype', width: 80 }, 			
			//{ label: '本文所拥有的图片', name: 'images', index: 'images', width: 80 },			
			{ label: 'url', name: 'url', index: 'url', width: 80 }			
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
		showList: true,
		title: null,
		tbDetails: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.tbDetails = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.tbDetails.id == null ? "tbdetails/save" : "tbdetails/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.tbDetails),
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
				    url: baseURL + "tbdetails/delete",
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
			$.get(baseURL + "tbdetails/info/"+id, function(r){
                vm.tbDetails = r.tbDetails;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});