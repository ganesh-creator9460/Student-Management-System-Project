<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<style type="text/css">
.enroll {
	background-image: url("images/enroll.jpg");
	background-size: cover;
	background-repeat: no-repeat;
}

.heading {
	font-family: cursive;
	text-align: center;
	margin-bottom: 20px;
}

form {
	width: 400px
}

.view {
	background-image: url("images/view.jpg");
	background-size: cover;
	background-repeat: no-repeat;
}

a {
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="card">
		<nav class="d-flex justify-content-between p-2 border border-primary">
			<img src="images/CJC logo.png" width="100px" height="50px">
			<div class="pt-2">
				<a href="#enroll">
					<button class="btn btn-outline-primary">Enroll Student</button>
				</a> <a href="#view">
					<button class="btn btn-outline-primary">View Student</button>
				</a> <a href="/">
					<button class="btn btn-outline-danger">Logout</button>
				</a>
			</div>
		</nav>
		<section class="vh-100 gradient-custom enroll mt-2" id="enroll">
			<div class="container-fluid mt-5 h-100">
				<div class="row justify-content-center h-100 w-75">
					<div class="col-12 col-lg-9 col-xl-7">
						<div class="card shadow-2-strong card-registration mt-0"
							style="border-radius: 15px;">
							<div class="card-body mt-0">
								<h3 class="heading">Student Enrollment Form</h3>
								<form action="enroll_student">
									<div class="row ">
										<div class="col-md-6 mb-2">
											<div class="form-outline">
												<input type="text" id="firstName"
													class="form-control form-control-sm" name="studentFullName"
													required /> <label class="form-label" for="firstName">First
													Full Name</label>
											</div>
										</div>
										<div class="col-md-6 mb-2">
											<div class="form-outline">
												<input type="email" id="lastName"
													class="form-control form-control-sm" name="studentEmail"
													required /> <label class="form-label" for="lastName">Student
													Email</label>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-6 mb-2 d-flex align-items-center">
											<div class="form-outline datepicker w-100">
												<input type="number" class="form-control form-control-sm"
													id="birthdayDate" name="studentAge" required /> <label
													for="birthdayDate" class="form-label">Student Age</label>
											</div>
										</div>
										<div class="col-md-6 mb-2 pb-2">
											<div class="form-outline">
												<input type="tel" id="text"
													class="form-control form-control-sm"
													name="studentCollageName" required /> <label
													class="form-label" for="text">Student Collage Name</label>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-6 mb-2 pb-2">
											<div class="form-outline">
												<input type="number" id="emailAddress"
													class="form-control form-control-sm" name="feesPaid"
													required /> <label class="form-label" for="emailAddress">Fees
													Paid</label>
											</div>
										</div>
										<div class="col-md-6 mb-2">
											<h6 class="mb-2 pb-1">Student Course :</h6>
											<div class="form-check form-check-inline">
												<input class="form-check-input" type="radio"
													name="studentCourse" id="java" value="Java" checked /> <label
													class="form-check-label" for="java">Java</label>
											</div>
											<div class="form-check form-check-inline">
												<input class="form-check-input" type="radio"
													name="studentCourse" id="python" value="Python" /> <label
													class="form-check-label" for="python">Python</label>
											</div>
											<div class="form-check form-check-inline">
												<input class="form-check-input" type="radio"
													name="studentCourse" id="testing" value="Testing" /> <label
													class="form-check-label" for="testing">Testing</label>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col">
											<select class="select form-control-sm" name="batchMode"
												required>
												<option value="#" disabled>Select Batch Mode</option>
												<option value="Online">Online</option>
												<option value="Offline">Offline</option>
											</select> <label class="form-label select-label">Batch Mode</label>
										</div>
										<div class="col">
											<select class="select form-control-sm" name="batchNumber"
												required>
												<option value="#" disabled>Select Batch Number</option>
												<option value="FDJ-160">FDJ-160</option>
												<option value="REG-160">REG-160</option>
												<option value="FDJ-161">FDJ-161</option>
												<option value="REG-198">REG-198</option>
												<option value="FDJ-198">FDJ-198</option>
												<option value="REG-161">REG-162</option>
												<option value="FDJ-162">FDJ-162</option>
												<option value="REG-162">REG-162</option>
												<option value="FDJ-163">FDJ-163</option>
												<option value="REG-163">REG-163</option>
												<option value="FDJ-164">FDJ-164</option>
												<option value="REG-164">REG-164</option>
												<option value="FDJ-165">FDJ-165</option>
												<option value="REG-165">REG-165</option>
											</select> <label class="form-label select-label">Batch Number</label>
										</div>
									</div>
									<div class="mt-2 pt-2 d-flex justify-content-center">
										<input class="btn btn-primary btn-lg" type="submit"
											value="Submit" />
									</div>
									<br>
									<marquee class="text-danger mb-3 fs-small "> ${error}
									</marquee>
									<marquee class="text-success mb-3 fs-small ">
										${success} </marquee>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>


		<section class="view" style="height: 100vh" id="view">
			<h1 class="text-center">Student Details..!</h1>

			<div class="text-center w-100">

				<form action="search" class="w-100">
					<select class="select form-control-sm border border-primary"
						name="batchMode">
						<option value="#" disabled>Select Batch Mode</option>
						<option value="Online">Online</option>
						<option value="Offline">Offline</option>
					</select> <select class="select form-control-sm border border-primary"
						name="batchNumber">
						<option value="#" disabled>Select Batch Number</option>
						<option value="FDJ-160">FDJ-160</option>
						<option value="REG-160">REG-160</option>
						<option value="FDJ-161">FDJ-161</option>
						<option value="REG-198">REG-198</option>
						<option value="FDJ-198">FDJ-198</option>
						<option value="REG-161">REG-162</option>
						<option value="FDJ-162">FDJ-162</option>
						<option value="REG-162">REG-162</option>
						<option value="FDJ-163">FDJ-163</option>
						<option value="REG-163">REG-163</option>
						<option value="FDJ-164">FDJ-164</option>
						<option value="REG-164">REG-164</option>
						<option value="FDJ-165">FDJ-165</option>
						<option value="REG-165">REG-165</option>
					</select>
					<button class="btn btn-outline-primary mb-1">Search</button>
				</form>

				<marquee>
					<h1 style="color: red;">${message}</h1>
				</marquee>

			</div>

			<table class=" table table-hover table-bordered" style="font-size: small;">

				<thead class="color-dark bg-white">
					<tr>

						<th>ID</th>
						<th>FullName</th>
						<th>Email</th>
						<th>Course</th>
						<th>Age</th>
						<th>CollageName</th>
						<th>FeesPaid</th>
						<th>BatchMode</th>
						<th>BatchNumber</th>
						<th>Action</th>

					</tr>
				</thead>

				<tbody>
					<c:forEach items="${data}" var="s">

						<tr>

							<td>${s.studentID}</td>
							<td>${s.studentFullName}</td>
							<td>${s.studentEmail}</td>
							<td>${s.studentCourse}</td>
							<td>${s.studentAge}</td>
							<td>${s.studentCollageName}</td>
							<td>${s.feesPaid}</td>
							<td>${s.batchMode}</td>
							<td>${s.batchNumber}</td>
							
							<td>

								<div class="btn-group  btn-group-sm" role="group">
									<a href="delete?id=${s.studentID}"><button
											class="btn btn-outline-danger">Remove</button></a> <a
										href="shift?id=${s.studentID}"><button
											class="btn btn-outline-primary">Shift Batch</button></a> <a
										href="pay?id=${s.studentID}"><button
											class="btn btn-outline-success">Pay Fees</button></a> <a
										href="edit?id=${s.studentID}"><button
											class="btn btn-outline-primary">Edit</button></a>
								</div>
							</td>
						</tr>

					</c:forEach>
				</tbody>

			</table>
			<br>

			<nav class="d-flex justify-content-center" aria-label="...">
				<ul class="pagination">

					<li class="page-item"><a class="page-link"
						href="paging?pageno=0">1</a></li>
					<li class="page-item"><a class="page-link"
						href="paging?pageno=1">2</a></li>
					<li class="page-item"><a class="page-link"
						href="paging?pageno=2">3</a></li>
					<li class="page-item"></li>
				</ul>
			</nav>

		</section>
	</div>
</body>
</html>