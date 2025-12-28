import * as React from 'react';
import Box from '@mui/material/Box';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import { Avatar, Stack } from '@mui/material';
import DugmiciKomentar from './DugmiciKomentar';
import KomentarThread from './KomentarThread';
import { DiskusijaContext } from './DiskusijaContext';
import KomentarForma from './KomentarForma';
import { Link } from 'react-router-dom';

// const bull = (
//     <Box
//       component="span"
//       sx={{ display: 'inline-block', mx: '2px', transform: 'scale(0.8)' }}
//     >
//       •
//     </Box>
//   );

let KomentarKartica = ({komid, rodKomId, korid, korime, diskid, tekst, datum, profilna, lajkovi, dislajkovi, lajkovan, odgovori, root, depth}) => {
  let {diskusija, setDiskusija} = React.useContext(DiskusijaContext)
  let [forma, setFroma] = React.useState(false)
  
  let podesiStil = (root) => {return root ? {} : {pl : 3}}
  let podesBoju = (root) => {return root ? {backgroundColor : '#42a5f5'} : {backgroundColor : '#bbdefb'}}

  let dateFormat = (dateString) => {
    let reformatDate = dateString.replace(' ', 'T')
    let date = new Date(reformatDate)

    let options = {
      year: 'numeric',
      month: 'long',
      day: 'numeric',
      hour: 'numeric',
      minute: 'numeric',
      hour12: true
    }

    return new Intl.DateTimeFormat('en-US', options).format(date)
  }

  // napraviti razliku korenski-odgovor komentara (razliciti backgroundColor!!!!!!!!!!!!)
  
  return (
    depth > 0 ?
        <Box sx={podesiStil(root)}>
        <Card sx={{ minWidth: 275 }} style={podesBoju(root)}>
      <CardContent>
        {/* <Typography gutterBottom sx={{ color: 'text.secondary', fontSize: 14 }}>
          Word of the Day
        </Typography> */}
        {/* <Typography variant="h5" component="div">
          be{bull}nev{bull}o{bull}lent
        </Typography> */}
        <Stack spacing={2} direction='row' justifyContent='space-between'>
            {/* <Typography>{datum}</Typography> */}
            <Typography>{dateFormat(datum)}</Typography>
            <Stack spacing={2} direction='row' alignItems='center'>
                <Typography>{korime}</Typography>
                <Avatar/>
            </Stack>
        </Stack>
        <Typography sx={{ color: 'text.secondary', mb: 1.5 }}>{tekst}</Typography>
        {depth == 1 ?
        <Typography sx={{ mb: 1.5 }}>
        <Link to={`/diskusija/${diskid}/komentar/${komid}`}>Nastavi diskusiju</Link>
      </Typography> : <></>}
        {/* <Typography variant="body2">
          well meaning and kindly.
          <br />
          {'"a benevolent smile"'}
        </Typography> */}
      </CardContent>
      <CardActions>
        {/* <Button size="small">Learn More</Button> */}
        <DugmiciKomentar {...{lajkovi, dislajkovi, lajkovan, komid}}/>
        {!forma? 
        <Button variant="contained" onClick={e=>{setFroma(true)}}>Odgovori</Button> :
        <Button variant="contained" color='error' onClick={e=>{setFroma(false)}}>Otkazi</Button>}
      </CardActions>
      {/* roditeljski komentar mora da bude trenutni id komentara!!!!!!!!!!
      jos uvek NE RADI KAKO TREBA!!!!!!!!!!!!!!!!!!!!!!!!! */}
      {forma ?
      <KomentarForma 
      diskid={diskusija != {} ? diskusija.diskid : 0} 
      rodKomId={komid} 
      setFroma={setFroma}/> :
      <></>}
    </Card>
    {
      odgovori?
      <KomentarThread 
      komentari={odgovori} 
      root={false} 
      depth={depth - 1}/>:<></>
    }
    </Box> : <></>
    )
}

export default KomentarKartica