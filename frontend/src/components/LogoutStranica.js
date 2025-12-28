import { useContext, useEffect } from "react"
import { KorisnikContext } from "./KorisnikContext"
import { useNavigate } from "react-router-dom"

let LogoutStranica = () => {
    let {korisnik, setKorisnik} = useContext(KorisnikContext)
    let navigate = useNavigate()

    function ocistitiStorage() {
        localStorage.clear()
    }

    setKorisnik(null)
    ocistitiStorage()

    useEffect(()=>{
        navigate('/')
    })

    return (
        <></>
    )
}

export default LogoutStranica