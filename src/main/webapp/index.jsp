<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/style.css">
<script src="${pageContext.request.contextPath}/JS/script.js" defer></script>
</head>
<body style="background-color: grey">
	<div class="form-container">
		<form id="address-form" action="${pageContext.request.contextPath}/homepage" method="post">
			<!-- Personal Information Section -->
			<h2>Personal Information</h2>
			<div class="form-section">
				<label for="first-name">First Name:</label> <input type="text"
					id="first-name" name="first-name" required>
			</div>
			<div class="form-section">
				<label for="middle-name">Middle Name:</label> <input type="text"
					id="middle-name" name="middle-name">
			</div>
			<div class="form-section">
				<label for="last-name">Last Name:</label> <input type="text"
					id="last-name" name="last-name" required>
			</div>
			<div class="form-section">
				<label for="dob">Date of Birth:</label> <input type="date" id="dob"
					name="dob" required>
			</div>
			<div class="form-section">
				<label for="age">Age:</label> <input type="number" id="age"
					name="age" readonly>
			</div>
			<div class="form-section">
				<label for="country">Country:</label> <select id="country"
					name="country" required>
					<option value="">Select Country</option>
					<option value="India">India</option>
					<option value="USA">USA</option>
				</select>
			</div>
			<div class="form-section">
				<label for="state">State:</label> <select id="state" name="state"
					required>
					<option value="">Select State</option>
				</select>
			</div>
			<div class="form-section">
				<label for="city">City:</label> <select id="city" name="city"
					required>
					<option value="">Select City</option>
				</select>
			</div>
			<div class="form-section">
				<label for="pincode">Pincode:</label> <input type="text"
					id="pincode" name="pincode" required>
			</div>

			<!-- Education Table Section -->
			<h2>Education</h2>
			<table id="education-table">
				<thead>
					<tr>
						<th>Class</th>
						<th>Marks</th>
						<th>Year of Passing</th>
						<th>College Name</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="text" name="class" placeholder="Class"
							required></td>
						<td><input type="number" name="marks" placeholder="Marks"
							required></td>
						<td><input type="number" name="year-of-passing"
							placeholder="Year of Passing" required></td>
						<td><input type="text" name="college-name"
							placeholder="College Name" required></td>
					</tr>
				</tbody>
			</table>

			<!-- Save Button -->
			<div class="form-section button-center">
				<button type="submit" id="save-button">Save</button>
			</div>
		</form>
	</div>
</body>
</html>
