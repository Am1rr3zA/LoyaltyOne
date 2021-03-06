import {Routes} from '@angular/router';
import { LoyaltyOneComponent } from './loyalty-one/loyalty-one.component';
import { LoginComponent } from './login/login.component';


export const routerConfig: Routes = [
    {
        path: 'home/:id',
        component: LoyaltyOneComponent
    },
    {
        path: 'login',
        component: LoginComponent
    },
    {
        path: '',
        pathMatch: 'full',
        redirectTo: 'login'
    },
    {
        path: '**',
        pathMatch: 'full',
        redirectTo: 'home'
    }
];
