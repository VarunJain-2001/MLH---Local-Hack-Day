import React from 'react';

type CounterButtonProps = {
    color?: string;
};

const CounterButton: React.FC<CounterButtonProps> = (props) => {
    return <button>{props.children}</button>;
};

export default CounterButton;
