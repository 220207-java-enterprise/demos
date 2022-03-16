import {ViewComponent} from '../view.js';

LoginComponent.prototype = new ViewComponent('login');
function LoginComponent() {

    let usernameField;
    let passwordField;
    let loginButton;
    let errorMessage;

    let un = '';
    let pw = '';

    // Use of the await keyword requires the function to be async
    async function login() {

        if (!un || !pw) {
            console.log('no username or password provided!');
            return;
        }

        let credentials = {
            username: un,
            password: pw
        }

        try {

            // await simplifies promise handling by "awaiting" the resolution of the promise
            let resp = await fetch('http://localhost:8080/quizzard/auth', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Accept': 'application/json'
                },
                body: JSON.stringify(credentials)
            });

            // = is assignment operator
            // == is "loose equality" (will attempt type coercion); 7 == '7' is true
            // === is "strict equality"; 7 === '7' is false
            if(resp.status === 400) {
                console.log('Invalid username or password given');
            }

            if (resp.status === 401) {
                console.log('Bad credentials given.');
            }

            if (resp.status === 200) {
                let payload = await resp.json();
                console.log('Successfully logged in!');
                console.log(payload);
            }

        } catch (e) {
            console.log(e.message);
        }

    }

    this.render = function() {
        LoginComponent.prototype.injectStyleSheet();
        LoginComponent.prototype.injectTemplate(() => {
    
            usernameField = document.getElementById('login-form-field-username');
            passwordField = document.getElementById('login-form-field-password');
            loginButton = document.getElementById('login-form-button');
            errorMessage = document.getElementById('error-msg');

    
            usernameField.addEventListener('keyup', function(e) {
                un = e.currentTarget.value;
            });

            passwordField.addEventListener('keyup', e => {
                pw = e.currentTarget.value;
            });

            loginButton.addEventListener('click', login);

        });
    }



}

// Only one ES6 default export allowed per script file
// Though, you can see include as many non-default exports as you'd like
export default new LoginComponent();
