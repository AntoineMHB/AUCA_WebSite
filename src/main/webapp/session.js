// session.js
var inactivityTimer;

function resetTimer() {
    clearTimeout(inactivityTimer);
    inactivityTimer = setTimeout(logout, 60000); // 1 minute
}

function logout() {
    // Send logout request to server
    var xhr = new XMLHttpRequest();
    xhr.open('GET', 'LogoutServlet', true);
    xhr.send();
}

// Listen for user activity events
document.addEventListener('mousemove', resetTimer);
document.addEventListener('keypress', resetTimer);

// Initial timer start
resetTimer();
