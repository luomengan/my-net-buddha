/********************* 数据对象 Controller ************************/
angular.module('dataObjectAdmin', [])
    .controller('dataObjectAdminController', dataObjectAdminControllerFn)
    .controller('dataObjectAddController', dataObjectAddControllerFn)
    .controller('dataObjectEditController', dataObjectEditControllerFn);

function dataObjectAdminControllerFn($scope, $modal, toaster, $http, tokenService) {
    $scope.dataObjectColumns = [
        { data: null, defaultContent: '', className: 'select-checkbox', width: 15},
        { data: 'id', title: '主键' }
        ,{ data: 'name', title: '名称' }
        ,{ data: 'description', title: '描述' }
        ,{ data: 'manageType', title: '数据管理类型' }
        ,{ data: 'manageIcon', title: '数据管理图标' }
        ,{ data: 'project.name', title: '对应的项目名称', "render": function(data, type, full, meta) {
            return full.project.id + "_" + full.project.name;
        }}
    ]

    // 添加按钮
    $scope.doDataObjectAdd = function() {
        $modal.open({
            templateUrl: 'dataObject_add.html',
            controller: 'dataObjectAddController',
            size: 'md'
        });
    }
    // 修改按钮
    $scope.doDataObjectEdit = function() {
        $modal.open({
            templateUrl: 'dataObject_edit.html',
            controller: 'dataObjectEditController',
            size: 'md'
        });
    }

    // 删除按钮
    $scope.doDataObjectRemove = function() {
        // 获取已选择的行id
        $scope.selectDataIds = [];
        var dtObj = $('#dataObjectAdminTable').dataTable();
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
            // 请求删除数据对象
            $http({
                method: 'post',
                url: '/code-generator1/dataObject/deletes',
                headers: {
                	'Content-Type': 'application/x-www-form-urlencoded' 
                },
                data: jQuery.param({ids: ids})
            }).then(function(response) {
                if(response.data.code === "200") {
                	$('#dataObjectAdminTable').dataTable().api().ajax.reload();
                    toaster.pop('success', '', '删除数据对象成功！');
                } else {
					toaster.pop('error', '', '删除数据对象失败：' + response.data.exception.message + "!");                    
                }
                $('#dataObjectAdminTable_wrapper').find(".btn-table-edit").attr("disabled", "disabled");
                $('#dataObjectAdminTable_wrapper').find(".btn-table-remove").attr("disabled", "disabled");
            }, function(response) {
                tokenService.handleHttpFailed(response);
            });
        });
    }
}

function dataObjectAddControllerFn($scope, $modalInstance, toaster, $http, tokenService) {
    $scope.dataObject = {
        manageType: "1",
        manageIcon: "icon-notebook"
    };
    
    // 请求添加
    $scope.requestDataObjectAdd = function(isValid) {
        if(isValid) {
            // 请求添加数据对象
            $http({
                method: 'post',
                url: '/code-generator1/dataObject/',
                headers: {
                	'Content-Type': 'application/x-www-form-urlencoded' 
                },
                data: jQuery.param($scope.dataObject)
            }).then(function(response) {
                if(response.data.code === "200") {
                    $('#dataObjectAdminTable').dataTable().api().ajax.reload();
                    $modalInstance.close();
                    toaster.pop('success', '', '添加数据对象成功！');
                } else {
					toaster.pop('error', '', '添加数据对象失败：' + response.data.exception.message + "!");                    
                }
            }, function(response) {
                tokenService.handleHttpFailed(response);
            });
        }
    }
}

function dataObjectEditControllerFn($scope, $modalInstance, toaster, $http, tokenService) {
    $scope.dataObject = {};
    // 获取已选择的行
    var selectData = null;
    var dtObj = $('#dataObjectAdminTable').dataTable();
    var nTrs = dtObj.fnGetNodes();
    for(var i = 0; i < nTrs.length; i++) {
        if(jQuery(nTrs[i]).hasClass('selected')) {
            selectData = dtObj.fnGetData(nTrs[i]);
        }
    }
    if(selectData) {
        jQuery.extend($scope.dataObject, selectData);
    }

    if($scope.dataObject.manageType == "基本管理") {
        $scope.dataObject.manageType = '1';
    } else if($scope.dataObject.manageType == "自身树管理") {
        $scope.dataObject.manageType = '2';
    } else if($scope.dataObject.manageType == "基于其他树管理") {
        $scope.dataObject.manageType = '3';
    } else if($scope.dataObject.manageType == "基于其他列表管理") {
        $scope.dataObject.manageType = '4';
    } 
    $scope.dataObject.projectId = $scope.dataObject.project.id;
    delete $scope.dataObject.project;

    // 请求修改
    $scope.requestDataObjectEdit = function(isValid) {
        if(isValid) {
            // 请求修改数据对象
            $http({
                method: 'put',
                url: '/code-generator1/dataObject/',
                headers: {
                	'Content-Type': 'application/x-www-form-urlencoded' 
                },
                data: jQuery.param($scope.dataObject)
            }).then(function(response) {
                if(response.data.code === "200") {
                	$('#dataObjectAdminTable').dataTable().api().ajax.reload();
                    $modalInstance.close();
                    toaster.pop('success', '', '修改数据对象成功！');
                } else {
                    toaster.pop('error', '', '修改数据对象失败：' + response.data.message + "!");
                }
                $('#dataObjectAdminTable_wrapper').find(".btn-table-edit").attr("disabled", "disabled");
                $('#dataObjectAdminTable_wrapper').find(".btn-table-remove").attr("disabled", "disabled");
            }, function(response) {
                tokenService.handleHttpFailed(response);
            });
        }
    }
}