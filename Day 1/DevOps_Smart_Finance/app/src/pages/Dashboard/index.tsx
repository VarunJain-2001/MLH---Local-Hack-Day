import React from 'react';
import CounterButton from 'components/button/counterButton';

const Dashboard: React.FC = () => {
    return (
        <div style={{ textAlign: 'center', marginTop: '40px' }}>
            <div style={{ fontSize: '30px' }}>Smart Finance.</div>
            <br />
            <CounterButton>Increment</CounterButton>
            <CounterButton>Decrement</CounterButton>
        </div>
    );
};

export default Dashboard;
