import { useContext } from "react"
import { useNavigate } from "react-router-dom"
import { RegistracijaContext } from "./RegistracijaContext"

let RegistracijaStranica = () => {
    let navigate = useNavigate()

    let {showReg, setShowReg} = useContext(RegistracijaContext)

    setShowReg(true)

    navigate('/')

    return (
        <></>
    )
}

export default RegistracijaStranica