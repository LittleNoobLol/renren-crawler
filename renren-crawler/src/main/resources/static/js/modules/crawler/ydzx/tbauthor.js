$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'tbauthor/list',
        datatype: "json",
        colModel: [			
			{ label: '编号', name: 'id', index: 'id', width: 50, key: true },
			{ label: '订阅人数', name: 'bookCount', index: 'book_count', width: 80 }, 			
			{ label: '头像url', name: 'channelImage', index: 'channel_image', width: 80 }, 			
			{ label: '姓名', name: 'channelName', index: 'channel_name', width: 80 }, 			
			{ label: '简介', name: 'channelSummary', index: 'channel_summary', width: 80 }, 			
			{ label: '父类型', name: 'channelType', index: 'channel_type', width: 80 }, 			
			{ label: '子类型', name: 'mediaDomain', index: 'media_domain', width: 80 }			
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
        	// 隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			authorUrl : null
		},
		showList: true,
		title: null,
		tbAuthor: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		author: function(){
			var authorurl=vm.q.authorUrl;
			if(authorurl==null){
				alert('作者连接不能为空');
				return;
			}
			var data="authorUrl="+authorurl;
			$.ajax({
				type: "POST",
			    url: baseURL + 'tbauthor/author',
			    data: data,
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功,作者名称是:'+r.data.name+',更新条数为:'+r.data.count, function(index){
							vm.q.authorUrl='';
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.tbAuthor = {};
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
			var url = vm.tbAuthor.id == null ? "tbauthor/save" : "tbauthor/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.tbAuthor),
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
				    url: baseURL + "tbauthor/delete",
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
			$.get(baseURL + "tbauthor/info/"+id, function(r){
                vm.tbAuthor = r.tbAuthor;
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