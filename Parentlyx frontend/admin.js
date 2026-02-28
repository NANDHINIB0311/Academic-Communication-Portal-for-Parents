// ================= DATA =================

let students = [ {name: "Arjun kumar", reg: "S101", class: "10", attendance: "95%", marks: 88, behavior: "Good"}, {name: "Meena R", reg: "S102", class: "10", attendance: "90%", marks: 75, behavior: "Average"}, {name: "Vikram S", reg: "S101", class: "10", attendance: "95%", marks: 88, behavior: "Good"}, {name: "Ravi R", reg: "S101", class: "10", attendance: "95%", marks: 88, behavior: "Good"}, {name: "Ram A", reg: "S101", class: "10", attendance: "95%", marks: 88, behavior: "Good"}, {name: "Site S", reg: "S101", class: "10", attendance: "95%", marks: 88, behavior: "Good"}, {name: "Lachu B", reg: "S101", class: "10", attendance: "95%", marks: 88, behavior: "Good"}, {name: "Harini G", reg: "S101", class: "10", attendance: "95%", marks: 88, behavior: "Good"} ];

let teachers = [ {name: "Mr. Smith", subject: "Math", email: "smith@example.com", mobile: "1234567890"}, {name: "Ms. Jane", subject: "Science", email: "jane@example.com", mobile: "0987654321"}, {name: "Mr. Mary", subject: "Math", email: "Mary@example.com", mobile: "6875934539"}, {name: "Ms. peter", subject: "Science", email: "peter@example.com", mobile: "3333444666"}, {name: "Mr. angle", subject: "Math", email: "angle@example.com", mobile: "0945623498"}, {name: "Ms. Jae", subject: "Science", email: "jae@example.com", mobile: "2347658737"}, {name: "Mr. Copper", subject: "Math", email: "copper@example.com", mobile: "1235645690"}, {name: "Ms. Mani", subject: "Science", email: "Mani@example.com", mobile: "0987656787"}, ];

let parents = [ {name: "Mr. John", mobile: "111222333", language: "English"}, {name: "Mrs. Mary", mobile: "444555666", language: "Tamil"}, {name: "Mr. Roe", mobile: "8749245233", language: "English"}, {name: "Mrs. Rani", mobile: "7653498567", language: "Tamil"}, {name: "Mr. Raja", mobile: "7349560214", language: "English"}, {name: "Mrs. Selvi", mobile: "9745023756", language: "Tamil"}, {name: "Mr. Durga", mobile: "7654848958", language: "English"}, {name: "Mrs. David", mobile: "9452568128", language: "English"} ];
let lastSection = "dashboard";

// ================= LOGIN =================

function login(event) {
    event.preventDefault();

    const adminID = document.getElementById("adminID").value;
    const password = document.getElementById("password").value;

    if (adminID === "admin" && password === "admin123") {
        document.getElementById("loginPage").classList.add("hidden");
        document.getElementById("dashboardPage").classList.remove("hidden");
        updateCounts();
    } else {
        document.getElementById("loginMsg").innerText = "❌ Invalid Admin ID or Password";
    }
}

function logout() {
    document.getElementById("dashboardPage").classList.add("hidden");
    document.getElementById("loginPage").classList.remove("hidden");
}

// ================= SECTION CONTROL =================

function showSection(sectionId) {
    document.querySelectorAll(".section").forEach(sec => {
        sec.classList.remove("active");
    });

    document.getElementById(sectionId).classList.add("active");

    if (sectionId !== "detailsModal") {
        lastSection = sectionId;
    }
}

function closeDetails() {
    showSection(lastSection);
}

// ================= COUNTS =================

function updateCounts() {
    document.getElementById("studentsCount").innerText = students.length;
    document.getElementById("teachersCount").innerText = teachers.length;
    document.getElementById("parentsCount").innerText = parents.length;
}

// ================= ADD FUNCTIONS =================

function addStudent(event){
    event.preventDefault();
    const name = document.getElementById('studentName').value;
    const reg = document.getElementById('studentReg').value;
    const cls = document.getElementById('studentClass').value;

    students.push({name, reg, class: cls, attendance: "0%", marks: 0, behavior: "Unknown"});
    updateCounts();
    event.target.reset();
}

function addTeacher(event){
    event.preventDefault();
    const name = document.getElementById('teacherName').value;
    const subject = document.getElementById('teacherSubject').value;
    const email = document.getElementById('teacherEmail').value;
    const mobile = document.getElementById('teacherMobile').value;

    teachers.push({name, subject, email, mobile});
    updateCounts();
    event.target.reset();
}

function addParent(event){
    event.preventDefault();
    const name = document.getElementById('parentName').value;
    const mobile = document.getElementById('parentMobile').value;
    const language = document.getElementById('parentLanguage').value;

    parents.push({name, mobile, language});
    updateCounts();
    event.target.reset();
}

// ================= LIST DISPLAY =================

function showStudentList(){
    const container = document.getElementById('studentListContainer');
    container.innerHTML = "";

    students.forEach((s, i) => {
        container.innerHTML += `
            <div class="entry">
                ${s.name} (${s.reg})
                <button onclick="viewStudentDetails(${i})">View</button>
            </div>`;
    });

    showSection('studentListSection');
}

function showTeacherList(){
    const container = document.getElementById('teacherListContainer');
    container.innerHTML = "";

    teachers.forEach((t, i) => {
        container.innerHTML += `
            <div class="entry">
                ${t.name} (${t.subject})
                <button onclick="viewTeacherDetails(${i})">View</button>
            </div>`;
    });

    showSection('teacherListSection');
}

function showParentList(){
    const container = document.getElementById('parentListContainer');
    container.innerHTML = "";

    parents.forEach((p, i) => {
        container.innerHTML += `
            <div class="entry">
                ${p.name}
                <button onclick="viewParentDetails(${i})">View</button>
            </div>`;
    });

    showSection('parentListSection');
}

// ================= DETAILS =================

function viewStudentDetails(index){
    const s = students[index];

    document.getElementById('detailsContainer').innerHTML = `
        <p><strong>Name:</strong> ${s.name}</p>
        <p><strong>Reg No:</strong> ${s.reg}</p>
        <p><strong>Class:</strong> ${s.class}</p>
        <p><strong>Attendance:</strong> ${s.attendance}</p>
        <p><strong>Marks:</strong> ${s.marks}</p>
        <p><strong>Behavior:</strong> ${s.behavior}</p>
    `;

    showSection('detailsModal');
}

function viewTeacherDetails(index){
    const t = teachers[index];

    document.getElementById('detailsContainer').innerHTML = `
        <p><strong>Name:</strong> ${t.name}</p>
        <p><strong>Subject:</strong> ${t.subject}</p>
        <p><strong>Email:</strong> ${t.email}</p>
        <p><strong>Mobile:</strong> ${t.mobile}</p>
    `;

    showSection('detailsModal');
}

function viewParentDetails(index){
    const p = parents[index];

    document.getElementById('detailsContainer').innerHTML = `
        <p><strong>Name:</strong> ${p.name}</p>
        <p><strong>Mobile:</strong> ${p.mobile}</p>
        <p><strong>Language:</strong> ${p.language}</p>
    `;

    showSection('detailsModal');
}

// ================= ANNOUNCEMENT =================

function sendAnnouncement() {
    const msg = document.querySelector('#announcement textarea').value;

    if(msg.trim() === ""){
        alert("Please enter a message");
        return;
    }

    alert("Announcement sent: " + msg);
    document.querySelector('#announcement textarea').value = "";
}