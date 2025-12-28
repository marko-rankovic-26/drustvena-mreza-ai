import { Box, FormControl } from "@mui/material"
import TextField from '@mui/material/TextField';
import { styled } from '@mui/material/styles';
import Button from '@mui/material/Button';
import CloudUploadIcon from '@mui/icons-material/CloudUpload';
import TemaSelect from "./TemaSelect";
import { useContext, useState } from "react";
import { KorisnikContext } from "./KorisnikContext";
import axios from "axios";
import { data } from "@remix-run/router";
import { useNavigate } from "react-router-dom";

const VisuallyHiddenInput = styled('input')({
    clip: 'rect(0 0 0 0)',
    clipPath: 'inset(50%)',
    height: 1,
    overflow: 'hidden',
    position: 'absolute',
    bottom: 0,
    left: 0,
    whiteSpace: 'nowrap',
    width: 1,
  });

let DiskusijaForma = () => {
    let {korisnik, setKorisnik} = useContext(KorisnikContext)
    let [temaid, setTemaid] = useState(0)
    let [naslov, setNaslov] = useState(null)
    let [tekst, setTekst] = useState(null)
    let [fajl, setFajl] = useState(null)
    let navigate = useNavigate()
    // dodati i fajl stanje!!!!!!!!!!!!!!!!!!!!!

    // console.log(`Trenutno je odabrana tema: ${temaid}`)

    // console.log(fajl)

    return (
        <Box width='100%'>
        <FormControl sx={{marginTop : 3}}
        component='form'
        onSubmit={e=>{
            e.preventDefault()

            if(temaid != 0) {
                let formdata = new FormData()
                let disk = {
                    korid : korisnik != null ? korisnik.korid : 0,
                    temaid : temaid,
                    naslov : naslov,
                    tekst : tekst
                }
                let jsonstring = JSON.stringify(disk)
                let blob = new Blob([jsonstring], {
                    type: 'application/json'
                })
                formdata.append('disk', blob)
                // formdata.append('fajl', fajl)

                if(fajl)
                    formdata.append('fajl', fajl)
                else {
                    let emptyFile = new File([], "empty.txt", { type: "text/plain" })
                    formdata.append('fajl', emptyFile)
                }

                axios.post('http://localhost:3001/diskusija', formdata, {
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                })
                .catch(err=>{console.log(err)})

                navigate('/')
            }
        }}>
            <TemaSelect temaId={temaid} setTemaId={setTemaid}/>
            <TextField
            autoFocus
            required
            id="outlined-required"
            label="Required"
            // defaultValue="Hello World"
            placeholder="Naslov"
            value={naslov}
            onChange={e=>{setNaslov(e.target.value)}}
            />
            <TextField
            autoFocus
            required
            id="outlined-required"
            label="Required"
            // defaultValue="Hello World"
            placeholder="Sadrzaj"
            multiline
            rows={4}
            sx={{width : "240px"}}
            margin="normal"
            value={tekst}
            onChange={e=>{setTekst(e.target.value)}}
            />
            <Button
      component="label"
      role={undefined}
      variant="contained"
      tabIndex={-1}
      startIcon={<CloudUploadIcon />}
    >
      Okaci sliku
      <VisuallyHiddenInput
        type="file"
        onChange={(event) => setFajl(event.target.files[0])}
        accept=".png,.jpeg,.jpg"
        // multiple
      />
    </Button>
    <Button variant="contained" sx={{marginTop : 2}} onClick={e=>{setFajl(null)}}>Ukloni sliku</Button>
    <Button variant="contained" sx={{marginTop : 2}} color="success" type="submit">Okaci</Button>
        </FormControl>
        <img src={fajl != null ? URL.createObjectURL(fajl) : ''} width='33%'/>
        </Box>
    )
}

export default DiskusijaForma