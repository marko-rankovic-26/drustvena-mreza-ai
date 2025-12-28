import { useEffect, useState } from "react"
import LoginPopup from "./LoginPopup"
import RespNavbar from "./RespNavbar"
import { Box, Container, Toolbar } from "@mui/material"
import { KorisnikContext } from "./KorisnikContext"
import { LoginContext } from "./LoginContext"
import { BrowserRouter, Route, Routes } from "react-router-dom"
import LoginStranica from "./LoginStranica"
import { RegistracijaContext } from "./RegistracijaContext"
import RegistracijaPopup from "./RegistracijaPopup"
import RegistracijaStranica from "./RegistracijaStranica"
import DiskusijaKartica from "./DiskusijaKartica"
import DugmiciDiskusija from "./DugmiciDiskusija"
import Grid from '@mui/material/Grid2';
import HomeStranica from "./HomeStranica"
import LogoutStranica from './LogoutStranica'
import DiskusijaStranica from "./DiskusijaStranica"
import TemeDiskusija from "./TemeDiskusija"
import DiskusijaForma from "./DiskusijaForma"
import DiskusijaDetalji from "./DiskusijaDetalji"
import ProfilnaStranica from "./ProfilnaStranica"

let ForumApp = () => {
    // korisnika cuvati u locaStorage u vidu (k ,v)
    // prilikom pokretanja citati iz LS ako ne postoji setovati u null
    // ako postoji citati parsirani JSON string i ucitati u usestate
    // prilikom logout ---> setovati usestate u null + ocistiti LS
    // ------------------------- RESEN PROBLEM ------------------------
    // P.S. - razmotriti koriscenje sessionStorage (ili ne)!!!!!!!!!!!!
    let [korisnik, setKorisnik] = useState(null)
    let [showLogin, setShowLogin] = useState(false)
    let [showReg, setShowReg] = useState(false)

    function citajStorage() {
        if(localStorage.getItem('user') != null) {
            setKorisnik(JSON.parse(localStorage.getItem('user')))
        }
        else
            setKorisnik(null)
    }

    // logger
    // console.log(korisnik)

    useEffect(()=>{
        citajStorage()
    }, [korisnik])

    return (
        <BrowserRouter>
            <Box sx={{display : 'flex'}}>
                <KorisnikContext.Provider value={{korisnik, setKorisnik}}>
                    <LoginContext.Provider value={{showLogin, setShowLogin}}>
                        <RegistracijaContext.Provider value={{showReg, setShowReg}}>
                            <RespNavbar/>
                            <LoginPopup/>
                            <RegistracijaPopup/>

                            {/* <Toolbar/> */}
                            {/* izvuci karticu ispod navbar-a!!!!!!!!!!!!! */}
                            

                            {/* <Box component="main" sx={{p : 3, display : 'block'}}>
                                <Toolbar/>
                            </Box> */}

                            {/* za responsive web stranicu routes komponentu staviti unutar
                                grid container-a, unutar grid item-a!!!!!!!!! */}

                            
                            {/* 
                            NAZIV TEME VECI HEADER NEGO NAZIV DISKUSIJE!!!!!!!!!!! (GOTOVO!!!!) */}

                            {/* HOME PAGE = NAZIVI TEMA => LINKOVI KA STRANICAMA DISK PO TEMAMA */}
                            {/* PILIKOM KLIKA NA DISKUSIJU THREAD ZA DISKUSIJU => BEZ HIJERARHIJE */}
                            {/* VISE DETALJA NA KLIK KOMENTARA */}
                            {/* PRIKAZ TEME ILI POSTA => NIJE ULOGOVAN (GOTOVO!!!!!!!!!!) */}
                            {/* DETALJI POSTA => ULOGOVAN (GOTOVO!!!!!!!!) */}

                            {/* NAPRAVITI STRANICU ZA PRODUBLJIVANJE STABLA KOMENTARA!!!!!!!! */}

                            <Box sx={{paddingTop : '64px', width : '100%'}}>
                                <Routes>
                                    <Route path="/login" element={<LoginStranica/>}/>
                                    <Route path="/reg" element={<RegistracijaStranica/>}/>
                                    <Route path="/" element={<HomeStranica/>}/>
                                    <Route path="/home" element={<HomeStranica/>}/>
                                    <Route path="/logout" element={<LogoutStranica/>}/>
                                    <Route path="/diskusija/:id" element={<DiskusijaStranica/>}/>
                                    <Route path="tema/:temaid" element={<TemeDiskusija/>}/>
                                    <Route path="/novadisk" element={<DiskusijaForma/>}/>
                                    <Route path="/diskusija/:diskid/komentar/:komid" element={<DiskusijaDetalji/>}/>
                                    <Route path="profilna" element={<ProfilnaStranica/>}/>
                                </Routes>
                            </Box>

                            {/* <Routes>
                                <Route path="/login" element={<LoginStranica/>}/>
                                <Route path="/reg" element={<RegistracijaStranica/>}/>
                                <Route path="/" element={<HomeStranica/>}/>
                                <Route path="/home" element={<HomeStranica/>}/>
                                <Route path="/logout" element={<LogoutStranica/>}/>
                            </Routes> */}
                        </RegistracijaContext.Provider>
                    </LoginContext.Provider>
                </KorisnikContext.Provider>
            </Box>
        </BrowserRouter>
    )
}

export default ForumApp