"use client"
import axios from 'axios'
import React, { useState } from 'react'
import { blob } from 'stream/consumers';

const page = () => {
  const [image, setImage] = useState(null);
  const [images, setImages] = useState([]);

  const getImage = () => {
    try {
      const res = axios.get('https://i1.wp.com/wallpaper.dog/large/20416022.jpg', { responseType: 'blob' })
      res.then((response: any) => {

        const blob = response.data;
        const imageUrl: any = URL.createObjectURL(blob);
        setImage(imageUrl);

        axios.post('https://api.waifu.pics/many/sfw/waifu', { "exclude": [] }).then((response2) => {
          setImages(response2.data.files);
        })

      })
    } catch (error) {
      console.log(error);
    }
  }

  return (
    <div className='min-w-full bg-transparent min-h-full fixed flex justify-center items-center'>
      <button onClick={getImage} className="get-data bg-slate-500 p-4 text-xl font-extrabold uppercase font-serif rounded">
        get random Image
      </button>
      <div >

        {
          image ? <div>


            < img src={image} className="left-0 right-0 top-0 bottom-0 fixed z-10 bg-purple-950" />

            <div className='left-0 right-0 top-0 bottom-0  fixed z-20 overflow-auto flex flex-wrap '>  {
              images.map((ele: any) => {
                return <img src={ele} className='z-20 max-w-56 max-h-56 h-fit m-4' />
              })
            }</div>

          </div>



            : image
        }






      </div>
    </div>
  )
}

export default page