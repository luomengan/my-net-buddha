<div class="wrapper-md" ng-controller="${dataObjectPojo.humpName}AdminController">
    <!-- toaster directive -->
    <toaster-container toaster-options="{'position-class': 'toast-top-right', 'close-button':true}"></toaster-container>
    <!-- / toaster directive -->
    <div class="panel panel-default mb0">
        <div class="table-responsive">
            <table id="${dataObjectPojo.humpName}AdminTable" 
                ui-jq="dataTable" 
                ui-options="{
                    ajax: '/${projectName}/${dataObjectPojo.humpName}/list'
                }" 
                ui-columns-attr="${dataObjectPojo.humpName}Columns" 
                ui-btn-add-click="do${dataObjectPojo.name}Add();" 
                ui-btn-edit-click="do${dataObjectPojo.name}Edit();" 
                ui-btn-remove-click="do${dataObjectPojo.name}Remove();" 
                class="table table-striped table-bordered m-b-none">
                <thead></thead>
                <tbody></tbody>
            </table>
        </div>
    </div>

    <script type="text/ng-template" id="${dataObjectPojo.humpName}_add.html">
        <div ng-include="'src/html/${dataObjectPojo.humpName}/${dataObjectPojo.humpName}_add.html'"></div>
    </script>
    <script type="text/ng-template" id="${dataObjectPojo.humpName}_edit.html">
        <div ng-include="'src/html/${dataObjectPojo.humpName}/${dataObjectPojo.humpName}_edit.html'"></div>
    </script>
</div>