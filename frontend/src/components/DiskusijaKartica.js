import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import CardActionArea from '@mui/material/CardActionArea';
import CardActions from '@mui/material/CardActions';
import DugmiciDiskusija from './DugmiciDiskusija';
import { Avatar, Stack } from '@mui/material';
import ChatIcon from '@mui/icons-material/Chat';
import IconButton from '@mui/material/IconButton';
import { useNavigate } from 'react-router-dom';
import { LoginContext } from './LoginContext';
import { KorisnikContext } from './KorisnikContext';

let DiskusijaKartica = ({brojKom, datum, dislajkovi, id, korid, korime, lajkovan, lajkovi, naslov, profilna, slika, tekst, tema, temaid, linkovan}) => {
  let navigate = useNavigate()
  let {showLogin, setShowLogin} = React.useContext(LoginContext)
  let {korisnik, setKorisnik} = React.useContext(KorisnikContext)

    return (
        <Card sx={{marginBottom : '5px'}}>
          <CardActionArea disabled={!linkovan} onClick={e=>{
            if(korisnik != null)
              navigate(`/diskusija/${id}`)
            else
              setShowLogin(true)
          }}>
            {/* <CardMedia
              component="img"
              height="140"
              image="/static/images/cards/contemplative-reptile.jpg"
              alt="green iguana"
            /> */}
            <CardContent>
              {/* <Typography gutterBottom variant="h5" component="div">
                Lizard
              </Typography> */}
              <Stack direction="row" spacing={1} alignItems='center' sx={{paddingBottom : 2, justifyContent : 'space-between'}}>
                {/* <Typography gutterBottom variant="h5" component="div">
                    {naslov}
                </Typography> */}
                <Button variant='contained' size='big' disabled sx={{fontSize : '18px'}}>{tema}</Button>
                <Stack direction="row" spacing={1} alignItems='center' sx={{paddingBottom : 2}}>
                    <Typography sx={{fontSize : 12}}>{korime}</Typography>
                    {/* ako korisnik ima sliku, proslediti bajtovski niz */}
                    <Avatar/>
                </Stack>
              </Stack>
              {/* <Typography>naziv teme</Typography> */}
              {/* <Button variant='contained' size='small' disabled>{tema}</Button> */}
              <Typography gutterBottom variant="h6" component="div">
                    {naslov}
                </Typography>
              <Typography variant="body2" sx={{ color: 'text.secondary', paddingTop : 2 }}>
                {tekst}
              </Typography>
            </CardContent>
            {/* prilikom prop drilling porveriti da li je link razlicti od ""!!!!!! 
            ako je jednak "", onda ne renderovati komponentu CardMedia!!!!!!!!!! */}
            
            {/* u CardMedia komponenti za prop image ubaci vrednost 
            localhost:3001/{slika}!!!!!!!!!!!!!!!!!!! */}
            {slika != null ?
            <CardMedia
            component="img"
            height="140"
            image={slika}
            alt="green iguana"
          /> : null}
            <Typography textAlign='right' sx={{paddingRight : 2, paddingTop : 2, fontSize : 14}}>{datum}</Typography>
          </CardActionArea>
          <CardActions sx={{justifyContent : 'space-between'}}>
            {/* <Button size="small" color="primary">
              Share
            </Button> */}
            <DugmiciDiskusija {...{lajkovan, lajkovi, dislajkovi, id}}/>
            {/* <Typography>12</Typography>
            <ChatIcon color='info'/> */}
            <Stack direction="row" spacing={1} alignItems='center'>
            <Typography>{brojKom}</Typography>
                <IconButton aria-label="delete" disabled color="primary">
                    <ChatIcon color='info'/>
                </IconButton>
            </Stack>
          </CardActions>
        </Card>
      );
}

export default DiskusijaKartica