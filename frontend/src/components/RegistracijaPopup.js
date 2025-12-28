import * as React from 'react';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import { RegistracijaContext } from './RegistracijaContext';
import Snackbar from '@mui/material/Snackbar';
import Alert from '@mui/material/Alert';
import { KorisnikContext } from './KorisnikContext';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

let RegistracijaPopup = () => {
  const [open, setOpen] = React.useState(false);

  let { showReg, setShowReg } = React.useContext(RegistracijaContext)
  let { korisnik, setKorisnik } = React.useContext(KorisnikContext)

  let [ime, setIme] = React.useState(null)
  let [prezime, setPrezime] = React.useState(null)
  let [korime, setKorime] = React.useState(null)
  let [lozinka, setLozinka] = React.useState(null)
  let [ponLoz, setPonLoz] = React.useState(null)

  let [alert, setAlert] = React.useState(false)

  // let navigate = useNavigate()

  let [msgIndex, setMsgIndex] = React.useState(0)
  let messages = [
    {
      severity : 'warning',
      prouka : 'Lozinke moraju biti iste!'
    },
    {
      severity : 'error',
      prouka : 'Korisnicko ime je zauzeto!'
    },
    {
      severity : 'success',
      prouka : 'Uspesno je registrovan korisnik!'
    }
  ]

  // const handleClickOpen = () => {
  //   setOpen(true);
  // };

  const handleClose = () => {
    // setOpen(false);
    setShowReg(false)
  };

  const handleCloseSnackbar = (event, reason) => {
    if (reason === 'clickaway') {
      return;
    }

    setAlert(false);
  };

  function lozinkeSuIste() {
    if (lozinka != ponLoz) {
      setMsgIndex(0)
      setAlert(true)

      return false
    }
    else
      return true
  }

  function resetInput() {
    setIme(null)
    setPrezime(null)
    setKorime(null)
    setLozinka(null)
    setPonLoz(null)
  }

  function registracija() {
    let data = {
      ime : ime,
      prezime : prezime,
      korime : korime,
      lozinka : lozinka
    }

    axios.post('http://localhost:3001/registracija', data)
    .catch(err=>{console.log(err)})
  }

  function loginProba() {
    let data = {
      korime : korime,
      lozinka : lozinka
    }

    axios.post('http://localhost:3001/login', data)
    .then(val=>{
      if(val.data == '') {
        setMsgIndex(1)
        setAlert(true)
      }
      else {
        setMsgIndex(2)
        setAlert(true)
        resetInput()
      }
    })
    .catch(err=>{console.log(err)})
  }

  return (
    <React.Fragment>
      {/* <Button variant="outlined" onClick={handleClickOpen}>
            Open form dialog
          </Button> */}
      <Dialog
        open={showReg}
        onClose={handleClose}
        PaperProps={{
          component: 'form',
          onSubmit: (event) => {
            event.preventDefault();

            // const formData = new FormData(event.currentTarget);
            // const formJson = Object.fromEntries(formData.entries());
            // const email = formJson.email;
            // console.log(email);

            if (lozinkeSuIste()) {
              // ovde se pravi request za registraciju!!!!!!!!!!!!!!!
              registracija()
              loginProba()
            }

            // handleClose();
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
            id="ime"
            name="ime"
            label="Ime"
            type="text"
            fullWidth
            variant="standard"
            value={ime}
            onChange={e => { setIme(e.target.value) }}
          />
          <TextField
            autoFocus
            required
            margin="dense"
            id="prezime"
            name="prezime"
            label="Prezime"
            type="text"
            fullWidth
            variant="standard"
            value={prezime}
            onChange={e => { setPrezime(e.target.value) }}
          />
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
            onChange={e => { setKorime(e.target.value) }}
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
            value={lozinka}
            onChange={e => { setLozinka(e.target.value) }}
          />
          <TextField
            autoFocus
            required
            margin="dense"
            id="lozpon"
            name="lozpon"
            label="Ponovite lozinku"
            type="password"
            fullWidth
            variant="standard"
            value={ponLoz}
            onChange={e => { setPonLoz(e.target.value) }}
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
          >Registruj se</Button>
        </DialogActions>
      </Dialog>
      <Snackbar open={alert} autoHideDuration={6000} onClose={handleCloseSnackbar}>
        <Alert
          onClose={handleCloseSnackbar}
          severity={messages[msgIndex].severity}
          variant="filled"
          sx={{ width: '100%' }}
        >
          {messages[msgIndex].prouka}
        </Alert>
      </Snackbar>


    </React.Fragment>
  );
}

export default RegistracijaPopup