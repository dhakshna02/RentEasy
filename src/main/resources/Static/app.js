// --- UI Toggling Logic ---
const signUpButton = document.getElementById('signUpButton');
const signInButton = document.getElementById('signInButton');
const container = document.getElementById('container');

signUpButton.addEventListener('click', () => {
    container.classList.add('right-panel-active');
});

signInButton.addEventListener('click', () => {
    container.classList.remove('right-panel-active');
});


// --- Sign-Up Form Submission ---
const signUpForm = document.getElementById('signUpForm');
const signUpMessage = document.getElementById('signUpMessage');

signUpForm.addEventListener('submit', async (event) => {
    event.preventDefault();
    signUpMessage.textContent = '';
    signUpMessage.className = 'message';

    const name = document.getElementById('name').value;
    const username = document.getElementById('signUpUsername').value;
    const mobileNumber = document.getElementById('mobileNumber').value;
    const password = document.getElementById('signUpPassword').value;

    const userData = { name, username, mobileNumber, password, confirmPassword: password };

    try {
        const response = await fetch('/api/auth/signup', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(userData)
        });

        if (response.ok) {
            signUpMessage.textContent = 'Sign-up successful! Please Sign In.';
            signUpMessage.classList.add('success');
            signUpForm.reset();
        } else {
            const errorText = await response.text();
            signUpMessage.textContent = `Error: ${errorText}`;
            signUpMessage.classList.add('error');
        }
    } catch (error) {
        signUpMessage.textContent = 'Network error. Please try again.';
        signUpMessage.classList.add('error');
    }
});


// --- Sign-In Form Submission ---
const signInForm = document.getElementById('signInForm');
const signInMessage = document.getElementById('signInMessage');

signInForm.addEventListener('submit', async (event) => {
    event.preventDefault();
    signInMessage.textContent = '';
    signInMessage.className = 'message';

    const username = document.getElementById('signInUsername').value;
    const password = document.getElementById('signInPassword').value;

    try {
        const response = await fetch('/api/auth/signin', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ username, password })
        });

        const responseText = await response.text();

        if (response.ok) {
            signInMessage.textContent = responseText; // e.g., "Sign in successful! Welcome back..."
            signInMessage.classList.add('success');
            // Here you would redirect to the main application page
            // window.location.href = '/dashboard';
        } else {
            signInMessage.innerHTML = `${responseText}. <a href="#" id="signUpLink">Need an account? Sign Up</a>`;
            signInMessage.classList.add('error');

            // Add event listener for the new dynamic link
            document.getElementById('signUpLink').addEventListener('click', (e) => {
                e.preventDefault();
                container.classList.add('right-panel-active');
            });
        }
    } catch (error) {
        signInMessage.textContent = 'Network error. Please try again.';
        signInMessage.classList.add('error');
    }
});