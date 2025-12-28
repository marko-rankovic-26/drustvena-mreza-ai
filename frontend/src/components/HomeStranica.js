import { useContext, useEffect, useState } from "react"
import DiskusijaKartica from "./DiskusijaKartica"
import { KorisnikContext } from "./KorisnikContext"
import axios from "axios"
import { Box, Button, Typography } from "@mui/material"
import { Link, useNavigate } from "react-router-dom"

let HomeStranica = () => {
    let {korisnik, setKorisnik} = useContext(KorisnikContext)
    // let [diskusije, setDiskusije] = useState([])
    let [teme, setTeme] = useState([])

    let navigate = useNavigate()

    // kasnije dodati paging komponentu pomocu sa brojem stranica pomocu get zahteva sa servera
    // i izmeniti obican get zahtev da podrzava stranicenje (isto get request)!!!!!!!!!!!!!!!

    // function vratiDuiskusije() {
    //     let data = {
    //         korid : korisnik != null ? korisnik.korid : 0
    //     }

    //     axios.get('http://localhost:3001/diskusija', {params : data})
    //     .then(val=>{setDiskusije(val.data)})
    //     .catch(err=>{console.log(err)})
    // }

    function vratiTeme() {
        axios.get('http://localhost:3001/teme')
        .then(val=>{setTeme(val.data)})
        .catch(err=>{console.log(err)})
    }

    useEffect(()=>{
        // vratiDuiskusije()
        vratiTeme()
    }, [korisnik, teme])

    return (
        // <DiskusijaKartica/>
        // ovo nadograditi sa prop drilling parametrima iz get zahteva
        // <Box sx={{paddingTop : '64px', width : '100%'}}>
        //     {diskusije.map(el=>{return <DiskusijaKartica {...el}/>})}
        // </Box>
        <>
        {/* {diskusije.map(el=>{return <DiskusijaKartica {...el} linkovan={true}/>})} */}
        {teme.map(el=>{
            return <Box key={el.id} sx={{p : 2}}>
                <Button 
                variant="contained" 
                onClick={e=>{navigate(`/tema/${el.id}`)}}
                >{el.naziv}</Button>
            </Box>
        })}
        </>
    )
}

export default HomeStranica