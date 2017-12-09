import {Routes} from '@angular/router';
import { LoyaltyOneComponent } from './loyalty-one/loyalty-one.component';
import { LoginComponent } from './login/login.component';


export const routerConfig: Routes = [
    {
        path: 'home',
        component: LoyaltyOneComponent
    },
    {
        path: 'login',
        component: LoginComponent
    },
    {
        path: '',
        pathMatch: 'full',
        redirectTo: 'home'
    },
    {
        path: '**',
        pathMatch: 'full',
        redirectTo: 'home'
    }
];
