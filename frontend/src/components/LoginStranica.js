import { useContext, useEffect } from "react"
import { LoginContext } from "./LoginContext"
import { useNavigate } from "react-router-dom"

let LoginStranica = () => {
    let {showLogin, setShowLogin} = useContext(LoginContext)
    // slicno napraviti i logout stranicu!!!!!!!!!!!!!!!!

    const navigate = useNavigate()

    setShowLogin(true)

    useEffect(()=>{
        navigate('/')
    })

    return (
        <></>
    )
}

export default LoginStranica