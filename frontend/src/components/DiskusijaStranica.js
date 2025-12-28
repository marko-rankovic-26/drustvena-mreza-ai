import { Box, Divider } from "@mui/material"
import { useContext, useEffect, useState } from "react"
import { useParams } from "react-router-dom"
import { KorisnikContext } from "./KorisnikContext"
import axios from "axios"
import DiskusijaKartica from './DiskusijaKartica'
import KomentarKartica from "./KomentarKartica"
import KomentarThread from "./KomentarThread"
import KomentarForma from "./KomentarForma"
import { DiskusijaContext } from "./DiskusijaContext"

let DiskusijaStranica = () => {
    let { id } = useParams()
    let {korisnik, setKorisnik} = useContext(KorisnikContext)
    let [diskusija, setDiskusija] = useState({})

    // let [komentari, setKomentari] = useState([])

    // console.log(diskusija)

    function vratiDiskusiju() {
        let data = {
            korid : korisnik != null ? korisnik.korid : 0
        }

        axios.get(`http://localhost:3001/diskusija/${id}`, {params : data})
        .then(val=>{setDiskusija(val.data)})
        .catch(err=>{console.log(err)})
    }

    // function vratiKomentare() {
    //     let data = {
    //         korid : korisnik != null ? korisnik.korid : 0,
    //         diskid : diskusija != {} ? diskusija.diskid : 0
    //     }

    //     axios.get('http://localhost:3001/komentar', {params : data})
    //     .then(val=>{console.log(val.data)})
    //     .catch(err=>{console.log(err)})
    // }

    useEffect(()=>{
        vratiDiskusiju()
        // vratiKomentare()
    }, [korisnik, diskusija])

    return (
        <>
        <DiskusijaKartica {...diskusija} linkovan={false}/>
        <KomentarForma 
        diskid={diskusija != null ? diskusija.diskid : 0} 
        rodkomid={null}/>
        <Divider/>
        {/* <KomentarThread komentari={diskusija.komentari} root={true}/> */}
        <DiskusijaContext.Provider value={{diskusija, setDiskusija}}>
            {/* DEPTH JE INDEKSIRAN => 0-n (0 = max, n = min) !!!!!!!!!! */}
            <KomentarThread komentari={diskusija.komentari} root={true} depth={3}/>
        </DiskusijaContext.Provider>
        {/* <KomentarKartica root={true}/> */}
        {/* ovde dodati komentare!!!!!!!!!!!!! */}
        </>
    )
}

export default DiskusijaStranica