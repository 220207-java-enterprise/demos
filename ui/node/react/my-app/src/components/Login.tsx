import { SyntheticEvent, useState } from "react";
import { useNavigate } from "react-router-dom";
import { Navigate } from "react-router-dom";
import { Principal } from "../models/principal";
import { authenticate } from "../remote/auth-service";
import ErrorMessage from "./ErrorMessage";

interface ILoginProps {
    currentUser: Principal | undefined,
    setCurrentUser: (nextUser: Principal | undefined) => void
}

function Login(props: ILoginProps) {

    // destructuring assignment
    let [username, setUsername] = useState('');
    //        ^          ^
    //      state      setter (for updating the state variable)

    const [password, setPassword] = useState<string>();
    const [errorMsg, setErrorMsg] = useState('');

    const navigate = useNavigate();


    let updateUsername = (e: SyntheticEvent) => {
        let usernameVal = (e.target as HTMLInputElement).value;
        console.log(usernameVal);
        // username = usernameVal; // YOU CANNOT UPDATE PIECES OF STATE LIKE THIS
        setUsername(usernameVal);
    }

    let updatePassword = function(e: SyntheticEvent) {
        let passwordVal = (e.target as HTMLInputElement).value;
        console.log(passwordVal);
        setPassword(passwordVal);
    }

    let login = async () => {
        
        if (!username || !password) {
            setErrorMsg('You must provide a username and password!');
            return;
        }

        try {

            let resp = await authenticate({username, password});

            if (resp.status === 400) {
                setErrorMsg('Invalid username or password provided!');
            }

            if (resp.status === 401) {
                setErrorMsg('No user found with provided credentials!');
            }

            if (resp.status === 200) {
                let authUser = await resp.data;
                console.log(authUser);
                props.setCurrentUser(authUser);
                navigate('/dashboard');
            }

        } catch (e: any) {
            console.log(e.message);
        }

    }

    return (
        props.currentUser ? <Navigate to="/dashboard"/> : 
        <>
            <h4>Log into your account</h4>
            <div>
                <input type="text" id="username" placeholder="Enter your username" onChange={updateUsername}/>
                <br/><br/>
                <input type="password" id="password" placeholder="Enter your password" onChange={updatePassword}/>
                <br/><br/>
                <button id="login-button" onClick={login}>Login</button>
                <br/><br/>
            </div>
            { errorMsg ? <ErrorMessage errorMessage={errorMsg}/> : <></> }
        </>
    );

}

export default Login;