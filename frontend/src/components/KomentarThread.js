import KomentarKartica from "./KomentarKartica"

// proslediti prop deph sa kojim se racuna da li se prikazuje link ka daljoj diskusiji!!!!!!!!!

let KomentarThread = ({komentari, root, depth}) => {
    return (
        // komentari.length > 0 ? 
        // komentari.map(el=>{
        //     return <KomentarKartica {...el} root={root}/>
        // }) : 
        // <></>
        <>
        {komentari?.map(el=>{
            return <KomentarKartica {...el} root={root} depth={depth}/>
        })}
        </>
    )
}

export default KomentarThread