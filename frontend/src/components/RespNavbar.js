import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import Menu from '@mui/material/Menu';
import MenuIcon from '@mui/icons-material/Menu';
import Container from '@mui/material/Container';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import Tooltip from '@mui/material/Tooltip';
import MenuItem from '@mui/material/MenuItem';
import AdbIcon from '@mui/icons-material/Adb';
import { KorisnikContext } from './KorisnikContext';
import { Link } from "react-router-dom";
import { LoginContext } from './LoginContext';

// const pages = ['Home', 'Otvori diskusiju', 'Registracija'];
const pages = [
  {
    naslov : 'Home',
    putanja : '/home'
  }, 
  {
    naslov : 'Otvori diskusiju',
    putanja : '/novadisk'
  },
  {
    naslov : 'Registracija',
    putanja : '/reg'
  }];
// const settings = ['Login'];

let RespNavbar = () => {
    let {korisnik, setKorisnik} = React.useContext(KorisnikContext)
    // ovde je greska!!!!!!!!!!!! (greska je uklonjena!!!!!!!!)
    // proverava se da li je korisnik null pa se prosledjuje na login prema tome!!!!!!!!!

    let forbidden = ['/novadisk']
    // lista sa zabranjenim linkovima!!!!!!! (logiku za login napraviti oko te liste)
    // dodati usecontext za prikazivanja login popup-a!!!!!!!!!!! + link ka login popup-u!!!!!!!!!!

    // dodati povratak na home prilikom klikom na logo!!!!!!!!!!!!!!!!!

    let {showLogin, setShowLogin} = React.useContext(LoginContext)

    let generisiOpcije = (korisnik) => {
      return korisnik == null ?
      [{
        naslov : 'Login',
        putanja : '/login'
      }] :
      [{
        naslov : 'Profilna',
        putanja : '/profilna'
      },
      {
        naslov : 'Logout',
        putanja : '/logout'
      }]
    }

    function spreciRedirekciju(e) {
      // console.log(e.target.href)
      // href -> vraca putanju linka!!!!!!!!!!!!!!!
      // console.log(new URL(e.target.href).pathname)
      let path = new URL(e.target.href).pathname

      if(forbidden.includes(path) && korisnik == null) {
        e.preventDefault()
        setShowLogin(true)
      }
      // console.log(showLogin)
    }

    const [anchorElNav, setAnchorElNav] = React.useState(null);
  const [anchorElUser, setAnchorElUser] = React.useState(null);

  const handleOpenNavMenu = (event) => {
    setAnchorElNav(event.currentTarget);
  };
  const handleOpenUserMenu = (event) => {
    setAnchorElUser(event.currentTarget);
  };

  const handleCloseNavMenu = () => {
    setAnchorElNav(null);
  };

  const handleCloseUserMenu = () => {
    setAnchorElUser(null);
  };

  return (
    <AppBar position="fixed">
      <Container maxWidth="xl">
        <Toolbar disableGutters>
          <AdbIcon sx={{ display: { xs: 'none', md: 'flex' }, mr: 1 }} />
          <Typography
            variant="h6"
            noWrap
            component="a"
            // href="#app-bar-with-responsive-menu"
            href="/"
            sx={{
              mr: 2,
              display: { xs: 'none', md: 'flex' },
              fontFamily: 'monospace',
              fontWeight: 700,
              letterSpacing: '.3rem',
              color: 'inherit',
              textDecoration: 'none',
            }}
          >
            LOGO
          </Typography>

          <Box sx={{ flexGrow: 1, display: { xs: 'flex', md: 'none' } }}>
            <IconButton
              size="large"
              aria-label="account of current user"
              aria-controls="menu-appbar"
              aria-haspopup="true"
              onClick={handleOpenNavMenu}
              color="inherit"
            >
              <MenuIcon />
            </IconButton>
            <Menu
              id="menu-appbar"
              anchorEl={anchorElNav}
              anchorOrigin={{
                vertical: 'bottom',
                horizontal: 'left',
              }}
              keepMounted
              transformOrigin={{
                vertical: 'top',
                horizontal: 'left',
              }}
              open={Boolean(anchorElNav)}
              onClose={handleCloseNavMenu}
              sx={{ display: { xs: 'block', md: 'none' } }}
            >
              {/* {pages.map((page) => (
                <MenuItem key={page.putanja} onClick={handleCloseNavMenu}>
                  <Typography sx={{ textAlign: 'center' }}>{page.naslov}</Typography>
                </MenuItem>
              ))} */}
              {pages.map((page) => (
                <MenuItem key={page.putanja} onClick={handleCloseNavMenu}>
                  <Typography sx={{ textAlign: 'center' }}>
                    <Link to={page.putanja} style={{textDecoration : 'none', color : 'black'}} onClick={e=>{spreciRedirekciju(e)}}>{page.naslov}</Link>
                    {/* {page.naslov} */}
                  </Typography>
                </MenuItem>
              ))}
            </Menu>
          </Box>
          <AdbIcon sx={{ display: { xs: 'flex', md: 'none' }, mr: 1 }} />
          <Typography
            variant="h5"
            noWrap
            component="a"
            href="#app-bar-with-responsive-menu"
            sx={{
              mr: 2,
              display: { xs: 'flex', md: 'none' },
              flexGrow: 1,
              fontFamily: 'monospace',
              fontWeight: 700,
              letterSpacing: '.3rem',
              color: 'inherit',
              textDecoration: 'none',
            }}
          >
            LOGO
          </Typography>
          {/* <Box sx={{ flexGrow: 1, display: { xs: 'none', md: 'flex' } }}>
            {pages.map((page) => (
              <Button
                key={page}
                onClick={handleCloseNavMenu}
                sx={{ my: 2, color: 'white', display: 'block' }}
              >
                {page.naslov}
              </Button>
            ))}
          </Box> */}
          <Box sx={{ flexGrow: 1, display: { xs: 'none', md: 'flex' } }}>
            {pages.map((page) => (
              <Button
                key={page.putanja}
                onClick={handleCloseNavMenu}
                sx={{ my: 2, color: 'white', display: 'block' }}
              >
                <Link to={page.putanja} style={{textDecoration : 'none', color : 'white'}} onClick={e=>{spreciRedirekciju(e)}}>{page.naslov}</Link>
                {/* {page.naslov} */}
              </Button>
            ))}
          </Box>
          {korisnik != null ?
          <Typography>{korisnik.korime}</Typography> :
          null}
          <Box sx={{ flexGrow: 0 }}>
            <Tooltip title="Open settings">
              <IconButton onClick={handleOpenUserMenu} sx={{ p: 0 }}>
                <Avatar alt="Remy Sharp" src="/static/images/avatar/2.jpg" />
              </IconButton>
            </Tooltip>
            <Menu
              sx={{ mt: '45px' }}
              id="menu-appbar"
              anchorEl={anchorElUser}
              anchorOrigin={{
                vertical: 'top',
                horizontal: 'right',
              }}
              keepMounted
              transformOrigin={{
                vertical: 'top',
                horizontal: 'right',
              }}
              open={Boolean(anchorElUser)}
              onClose={handleCloseUserMenu}
            >
              {/* {settings.map((setting) => (
                <MenuItem key={setting} onClick={handleCloseUserMenu}>
                  <Typography sx={{ textAlign: 'center' }}>{setting}</Typography>
                </MenuItem>
              ))} */}
              {generisiOpcije(korisnik).map((setting) => (
                <MenuItem key={setting.putanja} onClick={handleCloseUserMenu}>
                  <Typography sx={{ textAlign: 'center' }}>
                    <Link to={setting.putanja} style={{textDecoration : 'none', color : 'black'}} onClick={e=>{spreciRedirekciju(e)}}>{setting.naslov}</Link>
                  </Typography>
                </MenuItem>
              ))}
            </Menu>
          </Box>
        </Toolbar>
      </Container>
    </AppBar>
  );
}

export default RespNavbar