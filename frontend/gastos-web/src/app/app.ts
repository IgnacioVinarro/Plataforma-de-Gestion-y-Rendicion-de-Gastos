import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  protected passwordVisible = false;

  protected togglePasswordVisibility(): void {
    this.passwordVisible = !this.passwordVisible;
  }
}