import React, { useState } from 'react'

export default function TextForm(props) {

    const [text, setText] = useState("Enter text here");
    const handleOnChange = (event) => {
        setText(event.target.value)
    }
    const toUppercase = () => {
        setText(text.toLocaleUpperCase());
    }
    const toLowecase = () => {
        setText(text.toLocaleLowerCase());
    }
    const copyText = () => {
        navigator.clipboard.writeText(text);
    }

    const cleartext = () => {
        setText("");
    }

    const truncSpaces = () => {
        let newText = text.split(/[ ]+/);
        setText(newText.join(" "));
    }
    return (
        <div className='p-4'>
            <div className="container">
                <h1>{props.heading}</h1>
                <div className="mb-3"></div>
                <textarea name="" value={text} onChange={handleOnChange} className='form-control bg-secondary' id="my-box" cols="30" rows="10"></textarea>
                <button onClick={toUppercase} className="btn btn-primary mt-2 me-3">Convert to UPPERCASE</button>
                <button onClick={toLowecase} className="btn btn-primary mt-2">Convert to Lowercase</button>
                <button onClick={cleartext} className="btn btn-primary mt-2">Clear text</button>
                <button onClick={copyText} className="btn btn-primary mt-2">Copy text</button>
                <button onClick={truncSpaces} className="btn btn-primary mt-2">Remove Extra spaces</button>
            </div>
            <div className="container my-2">
                <h1>Your text summary</h1>
                <p>{text === '' ? 0 : text.split(" ").length} words and {text.length} characters. </p>
                <p>{0.008 * text.length} Minutes read </p>
                <h2 className='mt-3'>Preview</h2>
                <h5>{text}</h5>
            </div>
        </div>
    )
}
