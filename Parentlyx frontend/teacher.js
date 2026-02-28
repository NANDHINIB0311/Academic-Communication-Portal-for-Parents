// Login function
function login(event) {
    event.preventDefault();
    const teacherID = document.getElementById("teacherID").value;
    const password = document.getElementById("password").value;

    if(teacherID === "teacher1" && password === "1234") {
        document.getElementById("loginPage").classList.add("hidden");
        document.getElementById("dashboardPage").classList.remove("hidden");
        document.getElementById("loginMsg").innerText = "";
    } else {
        document.getElementById("loginMsg").innerText = "❌ Invalid Teacher ID or Password";
    }
}

// Logout function
function logout() {
    document.getElementById("dashboardPage").classList.add("hidden");
    document.getElementById("loginPage").classList.remove("hidden");
    document.getElementById("loginMsg").innerText = "Logged out successfully!";
    document.getElementById("updatedStudents").innerHTML = ""; // Clear updates
}

// Update student function
function updateStudent(button) {
    const row = button.closest("tr");
    const name = row.cells[0].innerText;
    const studentClass = row.cells[1].innerText;
    const attendance = row.querySelector(".attendance").value;
    const marks = row.querySelector(".marks").value;
    const behavior = row.querySelector(".behavior").value;
    const skills = row.querySelector(".skills").value;
    const notification = row.querySelector(".notification").value;

    // Create div for updated student
    const div = document.createElement("div");
    div.className = "studentUpdate";
    div.innerHTML = `<strong>${name} (${studentClass})</strong> updated: 
        Attendance=${attendance}%, Marks=${marks}, Behavior=${behavior}, Skills=${skills}, Notification="${notification}"`;

    // Append to updatedStudents section
    const updatedSection = document.getElementById("updatedStudents");
    updatedSection.appendChild(div);

    // Highlight briefly
    div.style.backgroundColor = "#d4edda"; // light green
    setTimeout(() => div.style.backgroundColor = "#f9f9f9", 1500);
}
