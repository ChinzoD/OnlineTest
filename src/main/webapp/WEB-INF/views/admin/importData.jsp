<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.jsp"%>

<div class="portlet box green">

	<%-- <div class="form-group">
		<form:form method="POST" class="register-form"
			action="importDataExl2007" enctype="multipart/form-data">
			<div>Excel File 2007:</div>
			<input name="excelfile2007" type="file">
			<button type="submit" id="register-submit-btn"
				class="btn btn-success uppercase pull-left">Submit</button>
		</form:form>
	</div> --%>
	<div class="portlet-title">
		<div class="caption">
			<i class="fa fa-edit"></i>Import Data
		</div>
	</div>
	<div class="portlet-body form">


		<form:form method="POST" class="register-form"
			action="importData" enctype="multipart/form-data">
			<div class="form-body">
				<div class="form-group last">
					<label class="col-md-3 control-label">Excel file</label>
					<div class="col-md-4">
						<div class="input-group">
							<span class="input-group-addon input-circle-left"> <i
								class="fa fa-file-excel-o"></i>
							</span> <input type="file" name="ExcelFile" class="form-control input-circle-right"
								placeholder="Email Address">
						</div>
					</div>
				</div>
			</div>
			<br/>
			<div class="form-actions">
				<div class="row">
					<div class="col-md-offset-3 col-md-9">
						<button type="submit" class="btn btn-circle blue">Import</button>
					</div>
				</div>
			</div>
		</form:form>
	</div>
</div>
