import * as React from 'react';
import IconButton from '@mui/material/IconButton';
import Stack from '@mui/material/Stack';
import ThumbDownIcon from '@mui/icons-material/ThumbDown';
import ThumbUpIcon from '@mui/icons-material/ThumbUp';
import { Typography } from '@mui/material';
import { KorisnikContext } from './KorisnikContext';
import { LoginContext } from './LoginContext';
import axios from 'axios';

let DugmiciKomentar = ({lajkovan, lajkovi, dislajkovi, komid}) => {
  let {korisnik, setKorisnik} = React.useContext(KorisnikContext)

  function lajkuj() {
    let data = {
      korid : korisnik != null ? korisnik.korid : 0,
      status : true
    }

    axios.post(`http://localhost:3001/komstatusi/${komid}`, data)
    .catch(err=>{console.log(err)})
  }

  function dislajkuj() {
    let data = {
      korid : korisnik != null ? korisnik.korid : 0,
      status : false
    }

    axios.post(`http://localhost:3001/komstatusi/${komid}`, data)
    .catch(err=>{console.log(err)})
  }

  function ukloniStatus() {
    let data = {
      korid : korisnik != null ? korisnik.korid : 0
    }

    axios.delete(`http://localhost:3001/komstatusi/${komid}`, {data : data})
    .catch(err=>{console.log(err)})
  }

  function izmeniStatus() {
    let data = {
      korid : korisnik != null ? korisnik.korid : 0,
      status : !lajkovan
    }

    axios.put(`http://localhost:3001/komstatusi/${komid}`, data)
    .catch(err=>{console.log(err)})
  }

  function onLajk() {
    if(lajkovan == null) {
      lajkuj()
    }
    else if(lajkovan) {
      ukloniStatus()
    }
    else if(!lajkovan) {
      izmeniStatus()
    }
  }

  function onDislajk() {
    if(lajkovan == null) {
      dislajkuj()
    }
    else if(lajkovan) {
      izmeniStatus()
    }
    else if(!lajkovan) {
      ukloniStatus()
    }
  }

    return (
        <Stack direction="row" spacing={1} alignItems='center'>
            <Typography>{lajkovi}</Typography>
            {/* ovde dodati onLajk funkciju!!!!! */}
          <IconButton aria-label="like" onClick={e=>{onLajk()}}>
            {/* <DeleteIcon /> */}
            {lajkovan != null && lajkovan ? 
            <ThumbUpIcon color='success'/> :
            <ThumbUpIcon/>}
          </IconButton>
          {/* ovde dodati onDislajk funkciju!!!! */}
          <IconButton aria-label="dislike" onClick={e=>{onDislajk()}}>
            {/* <DeleteIcon /> */}
            {lajkovan != null && !lajkovan ?
            <ThumbDownIcon color='error'/> :
            <ThumbDownIcon/>}
          </IconButton>
          <Typography>{dislajkovi}</Typography>
        </Stack>
    )
}

export default DugmiciKomentar