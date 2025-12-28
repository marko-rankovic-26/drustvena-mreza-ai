import { useContext, useEffect, useState } from "react"
import { useParams } from "react-router-dom"
import { KorisnikContext } from "./KorisnikContext"
import KomentarThread from "./KomentarThread"
import axios from "axios"

let DiskusijaDetalji = () => {
    let {diskid, komid} = useParams()
    let {korisnik, setKorisnik} = useContext(KorisnikContext)
    let [komentari, setKomentari] = useState([])

    function vratiOdgovore() {
        let data = {
            korid : korisnik != null ? korisnik.korid : 0,
            diskid : diskid,
            komid : komid
        }

        axios.get('http://localhost:3001/odgovor', {params : data})
        .then(val=>{setKomentari(val.data)})
        .catch(err=>{console.log(err)})
    }

    useEffect(()=>{
        vratiOdgovore()
    }, [korisnik, komentari, komid, diskid])

    return (
        <KomentarThread komentari={komentari} root={true} depth={4}/>
    )
}

export default DiskusijaDetalji