import * as React from 'react';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import { LoginContext } from './LoginContext';
import axios from 'axios'
import { KorisnikContext } from './KorisnikContext';

let LoginPopup = () => {
    const [open, setOpen] = React.useState(false);

    let [korime, setKorime] = React.useState(null)
    let [loz, setLoz] = React.useState(null)

    let {korisnik, setKorisnik} = React.useContext(KorisnikContext)
    // open treba da poseduje stanje context-a
    // openom se manipulise iz drugih komponenti pomocu context-a

    let {showLogin, setShowLogin} = React.useContext(LoginContext)

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    // setOpen(false);
    setShowLogin(false)

    //bonus
    setKorime(null)
    setLoz(null)
  };

  function cuvajStorage(k, v) {
    if(v != null) {
      // cuvaj u storage
      localStorage.setItem(k, JSON.stringify(v))
      // namesti state
      setKorisnik(v)
    }
  }

  return (
    <React.Fragment>
      {/* <Button variant="outlined" onClick={handleClickOpen}>
        Open form dialog
      </Button> */}
      <Dialog
        open={showLogin}
        onClose={handleClose}
        PaperProps={{
          component: 'form',
          onSubmit: (event) => {
            event.preventDefault();

            // const formData = new FormData(event.currentTarget);
            // const formJson = Object.fromEntries(formData.entries());
            // const email = formJson.email;
            // console.log(email);

            let data = {
              'korime' : korime,
              'lozinka' : loz
            }

            // P.S. -> for dummies: kada koristis formu salji post zahtev bilmezu!!!!!!!!!!!!!
            axios.post('http://localhost:3001/login', data)
            .then(val=>{cuvajStorage('user', val.data)})
            .catch(err=>{console.log(err)})

            // console.log(data)
            setKorime(null)
            setLoz(null)

            handleClose();
          },
        }}
      >
        {/* <DialogTitle>Subscribe</DialogTitle> */}
        <DialogContent>
          {/* <DialogContentText>
            To subscribe to this website, please enter your email address here. We
            will send updates occasionally.
          </DialogContentText> */}
          <TextField
            autoFocus
            required
            margin="dense"
            id="korime"
            name="korime"
            label="Korisnicko ime"
            type="text"
            fullWidth
            variant="standard"
            value={korime}
            onChange={e=>{setKorime(e.target.value)}}
          />
          <TextField
            autoFocus
            required
            margin="dense"
            id="lozinka"
            name="lozinka"
            label="Lozinka"
            type="password"
            fullWidth
            variant="standard"
            value={loz}
            onChange={e=>{setLoz(e.target.value)}}
          />
        </DialogContent>
        <DialogActions>
          <Button
          onClick={handleClose}
          variant="outlined"
          color='error'
          >Otkazi</Button>
          <Button 
          type="submit"
          variant="outlined"
          color='success'
          >Login</Button>
        </DialogActions>
      </Dialog>
    </React.Fragment>
  );
}

export default LoginPopup