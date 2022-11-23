// import { createElement } from './components/create.js';

function create() {
  // onDisplay.create = true;
  // onDisplay.delete = false;
  // onDisplay.update = false;
  // onDisplay.deposit = false;
  // onDisplay.withdraw = false;
  // onDisplay.exit = false;
  // console.log(onDisplay);
  // let p = document.createElement('p');
  // p.textContent = 'Im redered to create route';
  // document.getElementById('main').appendChild(p);
  document.getElementById('main').innerHTML = 'Im redered to delete route';
  // document.write()
}

function deleteacc() {
  document.getElementById('main').innerHTML = 'Im redered to delete route';
}

function update() {
  document.getElementById('main').innerHTML = 'Im redered to update route';
}

function deposit() {
  document.getElementById('main').innerHTML = 'Im redered to deposit route';
}

function withdraw() {
  document.getElementById('main').innerHTML = 'Im redered to withdraw route';
}

function exit() {
  document.getElementById('main').innerHTML = 'Im redered to exit route';
}
