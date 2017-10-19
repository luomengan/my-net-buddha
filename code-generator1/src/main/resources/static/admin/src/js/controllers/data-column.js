/********************* 数据列 Controller ************************/
angular.module('dataColumnAdmin', [])
    .controller('dataColumnAdminController', dataColumnAdminControllerFn)
    .controller('dataColumnAddController', dataColumnAddControllerFn)
    .controller('dataColumnEditController', dataColumnEditControllerFn);

function dataColumnAdminControllerFn($scope, $modal, toaster, $http, tokenService) {
    $scope.dataColumnColumns = [
        { data: null, defaultContent: '', className: 'select-checkbox', width: 15},
        { data: 'id', title: '主键' }
        ,{ data: 'name', title: '名称' }
        ,{ data: 'type', title: '类型' }
        ,{ data: 'description', title: '描述' }
        ,{ data: 'isDisplayInTable', title: '是否在管理表格中显示', "render": function(data, type, full, meta) {
            var displayData = full.isDisplayInTable;
            if(displayData){
                displayData = "是";
            }else{
                displayData = "否";
            }
            return displayData;
        }}
        ,{ data: 'dataObject.id', title: '对应的数据对象ID', "render": function(data, type, full, meta) {
            return full.dataObject.id + "_" + full.dataObject.name;
        }}
    ]

    // 添加按钮
    $scope.doDataColumnAdd = function() {
        $modal.open({
            templateUrl: 'dataColumn_add.html',
            controller: 'dataColumnAddController',
            size: 'md'
        });
    }
    // 修改按钮
    $scope.doDataColumnEdit = function() {
        $modal.open({
            templateUrl: 'dataColumn_edit.html',
            controller: 'dataColumnEditController',
            size: 'md'
        });
    }

    // 删除按钮
    $scope.doDataColumnRemove = function() {
        // 获取已选择的行id
        $scope.selectDataIds = [];
        var dtObj = $('#dataColumnAdminTable').dataTable();
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
            // 请求删除数据列
            $http({
                method: 'post',
                url: '/code-generator1/dataColumn/deletes',
                headers: {
                	'Content-Type': 'application/x-www-form-urlencoded' 
                },
                data: jQuery.param({ids: ids})
            }).then(function(response) {
                if(response.data.code === "200") {
                	$('#dataColumnAdminTable').dataTable().api().ajax.reload();
                    toaster.pop('success', '', '删除数据列成功！');
                } else {
					toaster.pop('error', '', '删除数据列失败：' + response.data.exception.message + "!");                    
                }
                $('#dataColumnAdminTable_wrapper').find(".btn-table-edit").attr("disabled", "disabled");
                $('#dataColumnAdminTable_wrapper').find(".btn-table-remove").attr("disabled", "disabled");
            }, function(response) {
                tokenService.handleHttpFailed(response);
            });
        });
    }
}

function dataColumnAddControllerFn($scope, $modalInstance, toaster, $http, tokenService) {
    $scope.dataColumn = {
        isDisplayInTable: 'true',
        type: '1'
    };
    
    // 请求添加
    $scope.requestDataColumnAdd = function(isValid) {
        if(isValid) {
            // 请求添加数据列
            $http({
                method: 'post',
                url: '/code-generator1/dataColumn/',
                headers: {
                	'Content-Type': 'application/x-www-form-urlencoded' 
                },
                data: jQuery.param($scope.dataColumn)
            }).then(function(response) {
                if(response.data.code === "200") {
                    $('#dataColumnAdminTable').dataTable().api().ajax.reload();
                    $modalInstance.close();
                    toaster.pop('success', '', '添加数据列成功！');
                } else {
					toaster.pop('error', '', '添加数据列失败：' + response.data.exception.message + "!");                    
                }
            }, function(response) {
                tokenService.handleHttpFailed(response);
            });
        }
    }
}

function dataColumnEditControllerFn($scope, $modalInstance, toaster, $http, tokenService) {
    $scope.dataColumn = {};
    // 获取已选择的行
    var selectData = null;
    var dtObj = $('#dataColumnAdminTable').dataTable();
    var nTrs = dtObj.fnGetNodes();
    for(var i = 0; i < nTrs.length; i++) {
        if(jQuery(nTrs[i]).hasClass('selected')) {
            selectData = dtObj.fnGetData(nTrs[i]);
        }
    }
    if(selectData) {
        jQuery.extend($scope.dataColumn, selectData);
    }

    if($scope.dataColumn.type == "字符") {
        $scope.dataColumn.type = '1';
    } else if($scope.dataColumn.type == "整数") {
        $scope.dataColumn.type = '2';
    } else if($scope.dataColumn.type == "长整数") {
        $scope.dataColumn.type = '3';
    } else if($scope.dataColumn.type == "双精度浮点数") {
        $scope.dataColumn.type = '4';
    } else if($scope.dataColumn.type == "布尔") {
        $scope.dataColumn.type = '5';
    } else if($scope.dataColumn.type == "日期") {
        $scope.dataColumn.type = '6';
    } else if($scope.dataColumn.type == "枚举") {
        $scope.dataColumn.type = '7';
    } else if($scope.dataColumn.type == "自身树") {
        $scope.dataColumn.type = '8';
    } 
    $scope.dataColumn.dataObjectId = $scope.dataColumn.dataObject.id;
    delete $scope.dataColumn.dataObject;

    // 请求修改
    $scope.requestDataColumnEdit = function(isValid) {
        if(isValid) {
            // 请求修改数据列
            $http({
                method: 'put',
                url: '/code-generator1/dataColumn/',
                headers: {
                	'Content-Type': 'application/x-www-form-urlencoded' 
                },
                data: jQuery.param($scope.dataColumn)
            }).then(function(response) {
                if(response.data.code === "200") {
                	$('#dataColumnAdminTable').dataTable().api().ajax.reload();
                    $modalInstance.close();
                    toaster.pop('success', '', '修改数据列成功！');
                } else {
                    toaster.pop('error', '', '修改数据列失败：' + response.data.message + "!");
                }
                $('#dataColumnAdminTable_wrapper').find(".btn-table-edit").attr("disabled", "disabled");
                $('#dataColumnAdminTable_wrapper').find(".btn-table-remove").attr("disabled", "disabled");
            }, function(response) {
                tokenService.handleHttpFailed(response);
            });
        }
    }
}