import { Avatar, Box, FormControl } from "@mui/material"
import Button from '@mui/material/Button';
import CloudUploadIcon from '@mui/icons-material/CloudUpload';
import * as React from 'react';
import { styled } from '@mui/material/styles';

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

let ProfilnaStranica = () => {
    let [slika, setSlika] = React.useState(null)

    return (
        <Box sx={{paddingTop : 3}}>
            <Avatar sx={{width : "128px", height : "128px"}} src={slika != null ? URL.createObjectURL(slika) : null}/>
            <FormControl>
                <Button variant="contained" color="error" onClick={e=>{setSlika(null)}} sx={{marginBottom : 2, marginTop : 2}}>Ukloni profilnu</Button>
                <Button
                sx={{marginBottom : 2, marginTop : 2}}
                component="label"
                role={undefined}
                variant="contained"
                tabIndex={-1}
                startIcon={<CloudUploadIcon />}
                >
                Dodaj profilnu
                <VisuallyHiddenInput
                    type="file"
                    // onChange={(event) => console.log(event.target.files)}
                    // multiple
                    accept=".jpeg, .jpg"
                    onChange={e=>{setSlika(e.target.files[0])}}
                />
                </Button>
                <Button variant="contained" color="success" sx={{marginBottom : 2, marginTop : 2}}>Sacuvaj</Button>
            </FormControl>
        </Box>
    )
}

export default ProfilnaStranica