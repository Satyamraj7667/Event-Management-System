import React from 'react'
import { Button, Paper, TextField } from '@mui/material';
import { useState } from 'react';
import Navbar from './../Components/Navbar'





function Event() {

    const [event1, setEvent] = useState({
        name: "",
        description: "",
        location : "",
        date: null
    });

    const handleChange = (event) => {
        const { name, value, type } = event.target;
        setEvent({ ...event, [name]: value });

    }

    const handleSubmit = (event) =>{
        event.preventDefault();

        console.log(event1)

    }
    

  return (
    <div>
        
        <Navbar></Navbar>
    <div className="container p-3" style={{ display: "flex", flexDirection: "column", boxShadow: '0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)', fontFamily: '"Roboto",sans-serif', marginTop: "15px", marginBottom: "15px" }}>
                <form onSubmit={handleSubmit}>
              
                <h3>Add Event</h3>


                    <div style={{ marginTop: "40px", width: "50%" }}>
                    <input type="text" name="name" placeholder="Enter title" className="form-control " value={event1.name} onChange={handleChange} required />
                    </div>

                    <div style={{ marginTop: "10px", width: "50%" }}>
                    <input type="text" name="description" placeholder="Enter Description" className="form-control " value={event1.description} onChange={handleChange} required />
                    </div>

                    <div style={{ marginTop: "10px", width: "50%" }}>
                    <input type="text" name="location" placeholder="Enter Location" className="form-control " value={event1.location} onChange={handleChange} required />
                    </div>

                    <div style={{ marginTop: "10px", width: "50%" }}>
                    <input type="date" name="date" placeholder="" className="form-control " value={event1.date} onChange={handleChange} required />
                    </div>
                    
                    <div style={{ marginTop: "10px", width: "50%" }}>
                        <Button type="submit" sx={{ width: "30%" }} variant="contained">submit</Button>
                    </div>
                </form>
            </div>

    </div>

  )
}

export default Event;