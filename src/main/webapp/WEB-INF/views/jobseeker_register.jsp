<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>JobSeeker Registration</title>

<style>
.error {
	color: #FF0000
}
</style>

<!-- CSS only -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" />
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script>
	$(function() {

		$('form[id="jobseekerForm"]').validate({
			rules : {
				jsName : 'required',
				jsDesg : 'required',
				resumeFile : 'required',
				photoFile : 'required',
			},
			messages : {
				jsName : 'Please enter job seeker name',
				jsDesg : 'Please enter job seeker designation',
				resumeFile : 'Please upload resume',
				photoFile : 'please upload photo',
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script>
</head>
<body>
	<div class="container my-5 border">
		<div class="card-header bg-secondary text-white">
			<h4>JobSeeker Registration</h4>
		</div>
		<div class="card-body">
			<form:form action="uploadfile" method="POST"
				modelAttribute="uploadModel" enctype="multipart/form-data"
				id="jobseekerForm">
				<div class="row">
					<div class="col-3">JobSeeker Name</div>
					<div class="col-4">
						<form:input path="jsName" />
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-3">JobSeeker Designation</div>
					<div class="col-4">
						<form:input path="jsDesg" />
					</div>
				</div>
				<br />

				<div class="row">
					<div class="col-3">JobSeeker Resume</div>
					<div class="col-4">
						<input type="file" name="resumeFile">
					</div>
				</div>
				<br />

				<div class="row">
					<div class="col-3">JobSeeker Photo</div>
					<div class="col-4">
						<input type="file" name="photoFile">
					</div>
				</div>
				<br />

				<input class="btn btn-primary" type="submit" value="Submit">
				<input class="btn btn-primary" type="reset" value="Reset">
			</form:form>
		</div>
	</div>
</body>
</html>
