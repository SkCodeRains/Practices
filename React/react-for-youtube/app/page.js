"use client"
import React, { useState } from 'react'
const page = () => {
  const [user] = useState("Code Rains");
  return (
    <>
      <h1 className='font-extrabold  text-xl'>{user}</h1>
    </>
  )
}

export default page

/*   /*             <h1 className='font-bold'>My Total user {user}</h1>
      <button onClick={() => { setUser(45) }} className='bg-gray-400 px-5 py-2 rounded mt-5 font-bold text-white'>
        Update
      </button> */