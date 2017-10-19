/********************* 佛音类别 Controller ************************/
angular.module('musicCategoryAdmin', [])
    .controller('musicCategoryAdminController', musicCategoryAdminControllerFn)
    .controller('musicCategoryAddController', musicCategoryAddControllerFn)
    .controller('musicCategoryEditController', musicCategoryEditControllerFn);

function musicCategoryAdminControllerFn($scope, $modal, toaster, $http, tokenService) {
    $scope.musicCategoryColumns = [
        { data: null, defaultContent: '', className: 'select-checkbox', width: 15},
        { data: 'id', title: '主键' }
        ,{ data: 'name', title: '名称' }
        ,{ data: 'author', title: '作者' }
        ,{ data: 'txtDescription', title: '描述' }
        ,{ data: 'level', title: '层级' }
        ,{ data: 'isHomeTop', title: '是否首页顶部推荐' }
        ,{ data: 'homeTopSortNum', title: '首页顶部推荐排序' }
        ,{ data: 'isRecommend', title: '是否推荐' }
        ,{ data: 'sortNum', title: '排序' }
        ,{ data: 'parentId', title: '父级类别' }
    ]

    // 添加按钮
    $scope.doMusicCategoryAdd = function() {
        $modal.open({
            templateUrl: 'musicCategory_add.html',
            controller: 'musicCategoryAddController',
            size: 'md'
        });
    }
    // 修改按钮
    $scope.doMusicCategoryEdit = function() {
        $modal.open({
            templateUrl: 'musicCategory_edit.html',
            controller: 'musicCategoryEditController',
            size: 'md'
        });
    }

    // 删除按钮
    $scope.doMusicCategoryRemove = function() {
        // 获取已选择的行id
        $scope.selectDataIds = [];
        var dtObj = $('#musicCategoryAdminTable').dataTable();
        var nTrs = dtObj.fnGetNodes();
        var ids = "";
        for(var i = 0; i < nTrs.length; i++) {
            if(jQuery(nTrs[i]).hasClass('selected')) {
                $scope.selectDataIds.push(dtObj.fnGetData(nTrs[i]).id);
                ids += dtObj.fnGetData(nTrs[i]).id + ",";
            }
        }

		if($scope.selectDataIds.length > 0) {
			ids = ids.substring(0, ids.length-1);
		}
        swal({
            title: "确定删除吗?",
            text: "确定删除后数据不可恢复!",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确定",
            cancelButtonText: "取消",
            closeOnConfirm: true
        }, function() {
            // 请求删除佛音类别
            $http({
                method: 'post',
                url: '/net-buddha/musicCategory/deletes',
                headers: {
                	'Content-Type': 'application/x-www-form-urlencoded' 
                },
                data: jQuery.param({ids: ids})
            }).then(function(response) {
                if(response.data.code === "200") {
                	$('#musicCategoryAdminTable').dataTable().api().ajax.reload();
                    toaster.pop('success', '', '删除佛音类别成功！');
                } else {
					toaster.pop('error', '', '删除佛音类别失败：' + response.data.exception.message + "!");                    
                }
                $('#musicCategoryAdminTable_wrapper').find(".btn-table-edit").attr("disabled", "disabled");
                $('#musicCategoryAdminTable_wrapper').find(".btn-table-remove").attr("disabled", "disabled");
            }, function(response) {
                tokenService.handleHttpFailed(response);
            });
        });
    }
}

function musicCategoryAddControllerFn($scope, $modalInstance, toaster, $http, tokenService) {
    $scope.musicCategory = {};
    
    // 请求添加
    $scope.requestMusicCategoryAdd = function(isValid) {
        if(isValid) {
            // 请求添加佛音类别
            $http({
                method: 'post',
                url: '/net-buddha/musicCategory/',
                headers: {
                	'Content-Type': 'application/x-www-form-urlencoded' 
                },
                data: jQuery.param($scope.musicCategory)
            }).then(function(response) {
                if(response.data.code === "200") {
                    $('#musicCategoryAdminTable').dataTable().api().ajax.reload();
                    $modalInstance.close();
                    toaster.pop('success', '', '添加佛音类别成功！');
                } else {
					toaster.pop('error', '', '添加佛音类别失败：' + response.data.exception.message + "!");                    
                }
            }, function(response) {
                tokenService.handleHttpFailed(response);
            });
        }
    }
}

function musicCategoryEditControllerFn($scope, $modalInstance, toaster, $http, tokenService) {
    $scope.musicCategory = {};
    // 获取已选择的行
    var selectData = null;
    var dtObj = $('#musicCategoryAdminTable').dataTable();
    var nTrs = dtObj.fnGetNodes();
    for(var i = 0; i < nTrs.length; i++) {
        if(jQuery(nTrs[i]).hasClass('selected')) {
            selectData = dtObj.fnGetData(nTrs[i]);
        }
    }
    if(selectData) {
        jQuery.extend($scope.musicCategory, selectData);
    }
    // 请求修改
    $scope.requestMusicCategoryEdit = function(isValid) {
        if(isValid) {
            // 请求修改佛音类别
            $http({
                method: 'put',
                url: '/net-buddha/musicCategory/',
                headers: {
                	'Content-Type': 'application/x-www-form-urlencoded' 
                },
                data: jQuery.param($scope.musicCategory)
            }).then(function(response) {
                if(response.data.code === "200") {
                	$('#musicCategoryAdminTable').dataTable().api().ajax.reload();
                    $modalInstance.close();
                    toaster.pop('success', '', '修改佛音类别成功！');
                } else {
                    toaster.pop('error', '', '修改佛音类别失败：' + response.data.message + "!");
                }
                $('#musicCategoryAdminTable_wrapper').find(".btn-table-edit").attr("disabled", "disabled");
                $('#musicCategoryAdminTable_wrapper').find(".btn-table-remove").attr("disabled", "disabled");
            }, function(response) {
                tokenService.handleHttpFailed(response);
            });
        }
    }
}