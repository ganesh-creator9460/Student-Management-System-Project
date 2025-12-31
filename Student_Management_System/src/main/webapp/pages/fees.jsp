<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<body>
	<div class="d-flex justify-content-center align-center">

		<div class="w-50 align-middle border border-info border-3 mt-2"
			style="height: 500px">

			<h6 class="p-3 text-primary">
				<u>Installment Details :-</u>
			</h6>

			<div class="border border-secondary m-3 p-2">

				<table class="table table-hover border border-secondary">

					<tbody>

						<tr class="table-primary fs-6">
							<th>Student ID</th>
							<td>${stu.studentID}</td>
						</tr>

						<tr class="table-primary fs-6">
							<th>Student Name</th>
							<td>${stu.studentFullName}</td>
						</tr>

						<tr class="table-primary fs-6">
							<th>Course Name</th>
							<td>${stu.studentCourse}</td>
						</tr>

						<tr class="table-primary fs-6">
							<th>Batch Number</th>
							<td>${stu.batchNumber}</td>
						</tr>

						<tr class="table-danger fs-6">
							<th>Fees Paid</th>
							<td>${stu.feesPaid}</td>
						</tr>

					</tbody>

				</table>

				<form action="payfees">

					<input type="number" name="studentID" value="${stu.studentID}"
						hidden="true">
					<div class="d-flex justify-content-between bg-dark p-2">
						<label class="text-info"><b>Enter
								Installment<br>Amount
						</b></label> <input type="number" name="amount">
					</div>

					<button class="btn btn-success btn-sm">Add Installment</button>

				</form>

			</div>

		</div>

	</div>

</body>
</html>