/********************* 佛音 Controller ************************/
angular.module('musicAdmin', [])
    .controller('musicAdminController', musicAdminControllerFn)
    .controller('musicAddController', musicAddControllerFn)
    .controller('musicEditController', musicEditControllerFn);

function musicAdminControllerFn($scope, $modal, toaster, $http, tokenService) {
    $scope.musicColumns = [
        { data: null, defaultContent: '', className: 'select-checkbox', width: 15},
        { data: 'id', title: '主键' }
        ,{ data: 'name', title: '名称' }
        ,{ data: 'author', title: '作者' }
        ,{ data: 'link', title: '资源链接' }
        ,{ data: 'isHomeTop', title: '是否首页顶部推荐' }
        ,{ data: 'homeTopSortNum', title: '首页顶部推荐排序' }
        ,{ data: 'isRecommend', title: '是否推荐' }
        ,{ data: 'sortNum', title: '排序' }
        ,{ data: 'categoryId', title: '所属类别' }
        ,{ data: 'playTimes', title: '播放次数' }
        ,{ data: 'duration', title: '音乐时长' }
    ]

    // 添加按钮
    $scope.doMusicAdd = function() {
        $modal.open({
            templateUrl: 'music_add.html',
            controller: 'musicAddController',
            size: 'md'
        });
    }
    // 修改按钮
    $scope.doMusicEdit = function() {
        $modal.open({
            templateUrl: 'music_edit.html',
            controller: 'musicEditController',
            size: 'md'
        });
    }

    // 删除按钮
    $scope.doMusicRemove = function() {
        // 获取已选择的行id
        $scope.selectDataIds = [];
        var dtObj = $('#musicAdminTable').dataTable();
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
            // 请求删除佛音
            $http({
                method: 'post',
                url: '/net-buddha/music/deletes',
                headers: {
                	'Content-Type': 'application/x-www-form-urlencoded' 
                },
                data: jQuery.param({ids: ids})
            }).then(function(response) {
                if(response.data.code === "200") {
                	$('#musicAdminTable').dataTable().api().ajax.reload();
                    toaster.pop('success', '', '删除佛音成功！');
                } else {
					toaster.pop('error', '', '删除佛音失败：' + response.data.exception.message + "!");                    
                }
                $('#musicAdminTable_wrapper').find(".btn-table-edit").attr("disabled", "disabled");
                $('#musicAdminTable_wrapper').find(".btn-table-remove").attr("disabled", "disabled");
            }, function(response) {
                tokenService.handleHttpFailed(response);
            });
        });
    }
}

function musicAddControllerFn($scope, $modalInstance, toaster, $http, tokenService) {
    $scope.music = {};
    
    // 请求添加
    $scope.requestMusicAdd = function(isValid) {
        if(isValid) {
            // 请求添加佛音
            $http({
                method: 'post',
                url: '/net-buddha/music/',
                headers: {
                	'Content-Type': 'application/x-www-form-urlencoded' 
                },
                data: jQuery.param($scope.music)
            }).then(function(response) {
                if(response.data.code === "200") {
                    $('#musicAdminTable').dataTable().api().ajax.reload();
                    $modalInstance.close();
                    toaster.pop('success', '', '添加佛音成功！');
                } else {
					toaster.pop('error', '', '添加佛音失败：' + response.data.exception.message + "!");                    
                }
            }, function(response) {
                tokenService.handleHttpFailed(response);
            });
        }
    }
}

function musicEditControllerFn($scope, $modalInstance, toaster, $http, tokenService) {
    $scope.music = {};
    // 获取已选择的行
    var selectData = null;
    var dtObj = $('#musicAdminTable').dataTable();
    var nTrs = dtObj.fnGetNodes();
    for(var i = 0; i < nTrs.length; i++) {
        if(jQuery(nTrs[i]).hasClass('selected')) {
            selectData = dtObj.fnGetData(nTrs[i]);
        }
    }
    if(selectData) {
        jQuery.extend($scope.music, selectData);
    }
    // 请求修改
    $scope.requestMusicEdit = function(isValid) {
        if(isValid) {
            // 请求修改佛音
            $http({
                method: 'put',
                url: '/net-buddha/music/',
                headers: {
                	'Content-Type': 'application/x-www-form-urlencoded' 
                },
                data: jQuery.param($scope.music)
            }).then(function(response) {
                if(response.data.code === "200") {
                	$('#musicAdminTable').dataTable().api().ajax.reload();
                    $modalInstance.close();
                    toaster.pop('success', '', '修改佛音成功！');
                } else {
                    toaster.pop('error', '', '修改佛音失败：' + response.data.message + "!");
                }
                $('#musicAdminTable_wrapper').find(".btn-table-edit").attr("disabled", "disabled");
                $('#musicAdminTable_wrapper').find(".btn-table-remove").attr("disabled", "disabled");
            }, function(response) {
                tokenService.handleHttpFailed(response);
            });
        }
    }
}