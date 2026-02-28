// ===== LOGIN FUNCTION =====
function login(event) {
    event.preventDefault();
    const parentID = document.getElementById("parentID").value;
    const password = document.getElementById("password").value;

    // DEMO CREDENTIALS
    if(parentID === "parent1" && password === "1234") {
        document.getElementById("loginPage").classList.add("hidden");
        document.getElementById("dashboardPage").classList.remove("hidden");
    } else {
        document.getElementById("loginMsg").innerText = "❌ Invalid Parent ID or Password";
    }
}

// ===== LOGOUT FUNCTION =====
function logout() {
    document.getElementById("dashboardPage").classList.add("hidden");
    document.getElementById("loginPage").classList.remove("hidden");
    document.getElementById("loginMsg").innerText = "Logged out successfully!";
}

// ===== FEEDBACK FORM =====
function submitFeedback(event) {
    event.preventDefault();
    document.getElementById("msg").innerText = "✔ Feedback submitted successfully!";
}

// ===== LANGUAGE TOGGLE =====
let tamil = false;
function toggleLanguage() {
    if(!tamil){
        // Change all dashboard text to Tamil
        document.getElementById("title").innerText = "Parentlyx - பெற்றோர் டாஷ்போர்டு";
        document.getElementById("student").innerText = "மாணவர்: அர்ஜுன் குமார்";
        document.getElementById("class").innerText = "வகுப்பு: 10 - A";
        document.getElementById("progressTitle").innerText = "கல்வி முன்னேற்ற நிலை";
        document.getElementById("gText").innerText = "கடந்த மாதத்துடன் ஒப்பிடுகையில் முன்னேற்றம் உள்ளது";
        document.getElementById("yText").innerText = "நிலைமை மாறாமல் உள்ளது, கண்காணிப்பு தேவை";
        document.getElementById("rText").innerText = "தொடர்ச்சியான சரிவு, உடனடி கவனம் தேவை";
        document.getElementById("behTitle").innerText = "நடத்தை மற்றும் திறன் வளர்ச்சி";
        document.getElementById("voice").innerText = "பெற்றோர் கருத்து (மாதாந்திர)";
        tamil = true;
    } else {
        // Switch back to English without reload
        document.getElementById("title").innerText = "Parentlyx - Parent Dashboard";
        document.getElementById("student").innerText = "Student: Arjun Kumar";
        document.getElementById("class").innerText = "Class: 10 - A";
        document.getElementById("progressTitle").innerText = "Academic Progress Overview";
        document.getElementById("gText").innerText = "Performance is improving compared to last month.";
        document.getElementById("yText").innerText = "Performance is stable but needs regular monitoring.";
        document.getElementById("rText").innerText = "Continuous decline detected. Immediate support required.";
        document.getElementById("behTitle").innerText = "Behaviour & Skill Development Log";
        document.getElementById("voice").innerText = "Parent Voice (Monthly Feedback)";
        tamil = false;
    }
}
