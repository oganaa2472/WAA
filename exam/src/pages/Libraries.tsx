
import { useState,useEffect } from 'react'
const API_BASE = "https://65bd8dd8b51f9b29e9338ba8.mockapi.io/api/v1/libraries";



  const Libraries = () => {
    const [libraries, setLibraries] = useState([]);
  
    useEffect(() => {
      fetch(API_BASE)
        .then(res => res.json())
        .then(setLibraries);
    }, []);
  
    return (
      <div>
        <h2>Libraries</h2>
        {/* {libraries.map(lib => <Library key={lib.id} library={lib} />)} */}
      </div>
    );
  };
  
  
export default Libraries;