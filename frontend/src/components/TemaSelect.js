import * as React from 'react';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';
import axios from 'axios';

let TemaSelect = ({temaId, setTemaId}) => {
    let [teme, setTeme] = React.useState([])
    // let [temaId, setTemaId] = React.useState(0)

    // console.log('Trenutno je odabrana tema: ' + temaId)

    // const [age, setAge] = React.useState('');

//   const handleChange = (event) => {
//     setAge(event.target.value);
//   };

  function vratiTeme() {
    axios.get('http://localhost:3001/teme')
    .then(val=>{setTeme(val.data)})
    .catch(err=>{console.log(err)})
  }

  React.useEffect(()=>{
    vratiTeme()
  }, [teme])

    return (
        <>
        <InputLabel id="demo-select-small-label" sx={{marginTop : 2, marginBottom : 2}}>Tema</InputLabel>
        <Select
        labelId="demo-select-small-label"
        id="demo-select-small"
        value={temaId}
        label="Tema"
        onChange={e=>{setTemaId(parseInt(e.target.value))}}
        size='small'
        sx={{marginTop : 2, marginBottom : 2}}
      >
        <MenuItem value={0}>
          <em>Nije odabrana nijedna tema</em>
        </MenuItem>
        {/* <MenuItem value={10}>Ten</MenuItem>
        <MenuItem value={20}>Twenty</MenuItem>
        <MenuItem value={30}>Thirty</MenuItem> */}
        {teme.map(el=>{
            return <MenuItem value={el.id} key={el.id}>{el.naziv}</MenuItem>
        })}
      </Select>
        </>
    )
}

export default TemaSelect