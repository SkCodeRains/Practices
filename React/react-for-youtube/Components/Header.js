import Link from 'next/link';
import React from 'react';

const Header = (props) => {
    return (
        <div className='h-8 px-6 flex items-center justify-between bg-purple-800 '>
            <h2 className='font-bold textxl'>{props.user}</h2>
            <div className='flex gap-3 me-10 font-bold textxl  '>
                <Link href="/About">About</Link>
                <Link href="/Courses">Courses</Link>
                <Link href="/Product">Product</Link>
            </div>
        </div>
    )
}

export default Header