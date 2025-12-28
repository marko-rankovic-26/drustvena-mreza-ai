import { useContext, useEffect, useState } from "react"
import { KorisnikContext } from "./KorisnikContext"
import { useParams } from "react-router-dom"
import axios from "axios"
import DiskusijaKartica from "./DiskusijaKartica"

let TemeDiskusija = () => {
    let {korisnik, setKorisnik} = useContext(KorisnikContext)
    let {temaid} = useParams()
    let [diskusije, setDiskusije] = useState([])

    console.log('Trenutna tema je: ' + temaid)

    function vratiDuiskusijeTeme() {
        let data = {
            korid : korisnik != null ? korisnik.korid : 0,
            temaid : temaid
        }

        axios.get('http://localhost:3001/diskusije', {params : data})
        .then(val=>{setDiskusije(val.data)})
        .catch(err=>{console.log(err)})
    }

    useEffect(()=>{
        vratiDuiskusijeTeme()
    }, [korisnik, diskusije])

    return (
        <>
        {diskusije.map(el=>{return <DiskusijaKartica {...el} linkovan={true}/>})}
        </>
    )
}

export default TemeDiskusija