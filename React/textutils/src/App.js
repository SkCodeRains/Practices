import './App.css';
import Accordion from './components/Accordion';
import Navbar from './components/Navbar';
import TextForm from './components/TextForm';

function App() {
  return (
    <div>
      <Navbar title={"CodeRains"} />
      <TextForm heading="Enter text"  ></TextForm>
      <Accordion />
    </div>
  );
}

export default App;
