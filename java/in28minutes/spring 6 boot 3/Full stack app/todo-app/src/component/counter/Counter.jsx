import React, { useState } from 'react'
import PropTypes from 'prop-types';
import "./Counter.css"



export const Calculator = () => {
    const [countTotal, setCountTotal] = useState(0);


    const incrementCount = (number) => {
        setCountTotal(countTotal + number);
    }
    const decrementCount = (number) => {
        setCountTotal(countTotal - number);
    }
    const resetCounter = () => {
        setCountTotal(0);
    }


    return (
        <>
            <span className='count'>{countTotal}</span>
            <Counter incrementCount={incrementCount} decrementCount={decrementCount}></Counter>
            <Counter incrementCount={incrementCount} decrementCount={decrementCount} differenceBy={2}></Counter >
            <Counter incrementCount={incrementCount} decrementCount={decrementCount} differenceBy={5}></Counter >
            <button className="roundbutton" onClick={resetCounter} >Reset Count</button>

        </>
    )
};

export const Counter = ({ differenceBy, incrementCount, decrementCount }) => {

    const incrementCountBy = () => {
        incrementCount(differenceBy);
    }
    const decrymentBy = () => {
        decrementCount(differenceBy);
    }
    return (
        <>
            <div className='counter'>

                <div className='buttons'>
                    <div>
                        <button className="roundbutton" onClick={incrementCountBy} >+{differenceBy}</button>
                    </div>

                    <div>
                        <button className="roundbutton" onClick={decrymentBy} >-{differenceBy}</button>
                    </div>
                </div>
            </div>
        </>
    )
}


Counter.propTypes = {
    differenceBy: PropTypes.number.isRequired, // Specify the expected type
};

Counter.defaultProps = {
    differenceBy: 1,
};