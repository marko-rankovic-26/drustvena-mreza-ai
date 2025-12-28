import { Box, FormControl } from "@mui/material"
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import { useContext, useState } from "react";
import { KorisnikContext } from "./KorisnikContext";
import axios from "axios";

let KomentarForma = ({diskid, rodKomId, setFroma}) => {
    let [tekst, setTekst] = useState(null)
    let {korisnik, setKorisnik} = useContext(KorisnikContext)

    function posaljiKomentar(data) {

        axios.post('http://localhost:3001/komentar', data)
        .catch(err=>{console.log(err)})
    }

    return (
        <Box sx={{width : '100%'}}>
            <FormControl
            component='form'
            onSubmit={e=>{
                e.preventDefault()

                let data = {
                    diskid: diskid,
                    rodKomId: rodKomId,
                    korid: korisnik != null ? korisnik.korid : 0,
                    tekst: tekst
                }

                setTekst('')

                posaljiKomentar(data)

                if(setFroma)
                    setFroma(false)
            }}>
                <TextField id="outlined-basic" label="Tekst" variant="outlined" sx={{width : 1000}} rows={5} multiline required value={tekst} onChange={e=>{setTekst(e.target.value)}}/>
                <Button variant="contained" sx={{width : 220}} type="submit">Okaci komentar</Button>
            </FormControl>
        </Box>
    )
}

export default KomentarForma