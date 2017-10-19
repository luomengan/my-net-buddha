/********************* 项目 Controller ************************/
angular.module('projectAdmin', [])
    .controller('projectAdminController', projectAdminControllerFn)
    .controller('projectAddController', projectAddControllerFn)
    .controller('projectEditController', projectEditControllerFn);

function projectAdminControllerFn($scope, $modal, toaster, $http, tokenService) {
    $scope.projectColumns = [
        { data: null, defaultContent: '', className: 'select-checkbox', width: 15},
        { data: 'id', title: '主键' }
        ,{ data: 'name', title: '项目名称' }
        ,{ data: 'basePackage', title: '项目主包' }
        ,{ data: 'description', title: '项目描述' }
        ,{ data: 'mavenGroupId', title: 'mavenGroupId' }
        ,{ data: 'mavenArtifactId', title: 'mavenArtifactId' }
        ,{ data: 'mavenVersion', title: 'mavenVersion' }
    ]

    // 添加按钮
    $scope.doProjectAdd = function() {
        $modal.open({
            templateUrl: 'project_add.html',
            controller: 'projectAddController',
            size: 'md'
        });
    }
    // 修改按钮
    $scope.doProjectEdit = function() {
        $modal.open({
            templateUrl: 'project_edit.html',
            controller: 'projectEditController',
            size: 'md'
        });
    }

    // 删除按钮
    $scope.doProjectRemove = function() {
        // 获取已选择的行id
        $scope.selectDataIds = [];
        var dtObj = $('#projectAdminTable').dataTable();
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
            // 请求删除项目
            $http({
                method: 'post',
                url: '/code-generator1/project/deletes',
                headers: {
                	'Content-Type': 'application/x-www-form-urlencoded' 
                },
                data: jQuery.param({ids: ids})
            }).then(function(response) {
                if(response.data.code === "200") {
                	$('#projectAdminTable').dataTable().api().ajax.reload();
                    toaster.pop('success', '', '删除项目成功！');
                } else {
					toaster.pop('error', '', '删除项目失败：' + response.data.exception.message + "!");                    
                }
                $('#projectAdminTable_wrapper').find(".btn-table-edit").attr("disabled", "disabled");
                $('#projectAdminTable_wrapper').find(".btn-table-remove").attr("disabled", "disabled");
            }, function(response) {
                tokenService.handleHttpFailed(response);
            });
        });
    }
}

function projectAddControllerFn($scope, $modalInstance, toaster, $http, tokenService) {
    $scope.project = {};
    
    // 请求添加
    $scope.requestProjectAdd = function(isValid) {
        if(isValid) {
            // 请求添加项目
            $http({
                method: 'post',
                url: '/code-generator1/project/',
                headers: {
                	'Content-Type': 'application/x-www-form-urlencoded' 
                },
                data: jQuery.param($scope.project)
            }).then(function(response) {
                if(response.data.code === "200") {
                    $('#projectAdminTable').dataTable().api().ajax.reload();
                    $modalInstance.close();
                    toaster.pop('success', '', '添加项目成功！');
                } else {
					toaster.pop('error', '', '添加项目失败：' + response.data.exception.message + "!");                    
                }
            }, function(response) {
                tokenService.handleHttpFailed(response);
            });
        }
    }
}

function projectEditControllerFn($scope, $modalInstance, toaster, $http, tokenService) {
    $scope.project = {};
    // 获取已选择的行
    var selectData = null;
    var dtObj = $('#projectAdminTable').dataTable();
    var nTrs = dtObj.fnGetNodes();
    for(var i = 0; i < nTrs.length; i++) {
        if(jQuery(nTrs[i]).hasClass('selected')) {
            selectData = dtObj.fnGetData(nTrs[i]);
        }
    }
    if(selectData) {
        jQuery.extend($scope.project, selectData);
    }
    // 请求修改
    $scope.requestProjectEdit = function(isValid) {
        if(isValid) {
            // 请求修改项目
            $http({
                method: 'put',
                url: '/code-generator1/project/',
                headers: {
                	'Content-Type': 'application/x-www-form-urlencoded' 
                },
                data: jQuery.param($scope.project)
            }).then(function(response) {
                if(response.data.code === "200") {
                	$('#projectAdminTable').dataTable().api().ajax.reload();
                    $modalInstance.close();
                    toaster.pop('success', '', '修改项目成功！');
                } else {
                    toaster.pop('error', '', '修改项目失败：' + response.data.message + "!");
                }
                $('#projectAdminTable_wrapper').find(".btn-table-edit").attr("disabled", "disabled");
                $('#projectAdminTable_wrapper').find(".btn-table-remove").attr("disabled", "disabled");
            }, function(response) {
                tokenService.handleHttpFailed(response);
            });
        }
    }
}